package by.tms.tkach.lesson48.repositories.user;

import by.tms.tkach.lesson48.entities.Task;
import by.tms.tkach.lesson48.entities.User;
import by.tms.tkach.lesson48.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    private final EntityManager entityManager;

    @Override
    public List<Task> getUserTasks(Long id) {
        try (Session session = sessionFactory.openSession().getSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Task> query = session.createQuery("FROM Task task WHERE task.user.id = :userId ");
            query.setParameter("userId", id);
            transaction.commit();
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Cannot find user tasks + " + e.getMessage());
        }
    }

    @Transactional
    public User save(User user) {
        try (Session session = sessionFactory.openSession().getSession()) {
            session.saveOrUpdate(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Cannot save user");
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User");
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Cannot find all user");
        }
    }


    @Override
    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cannot find user");
        }
    }

    @Override
    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Can't update task " + e.getMessage() + ". " + e.getCause());
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession().getSession()) {
            User user = findById(id);

            if (user != null) {
                Transaction transaction = session.beginTransaction();
                Query query = session.createQuery("DELETE FROM User user WHERE id = :userId");
                query.setParameter("userId", id);
                query.executeUpdate();
                transaction.commit();
            }
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Can't delete task because not exist task with this id");
        }
        catch (Exception e) {
            throw new RuntimeException("Cannot delete user");
        }
    }
}
