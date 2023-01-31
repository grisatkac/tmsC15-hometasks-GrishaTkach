package by.tms.tkach.lesson48.repositories.task;

import by.tms.tkach.lesson48.entities.Task;
import by.tms.tkach.lesson48.entities.User;
import by.tms.tkach.lesson48.exceptions.ResourceNotFoundException;
import by.tms.tkach.lesson48.mappers.TaskMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
public class TaskRepositoryImpl implements TaskRepository{

    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public Task save(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(task);
            return task;
        } catch (Exception e) {
            throw new RuntimeException("Cannot save task" + e.getMessage());
        }
    }

    @Override
    public List<Task> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Task> query = session.createQuery("FROM Task");
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Cannot find all tasks");
        }
    }

    @Override
    public Task findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Task task = session.get(Task.class, id);
            task.getUser();
            return task ;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cannot find task");
        }
    }

    @Override
    public Task update(Task task) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(task);
            transaction.commit();
            return task;
        } catch (Exception e) {
            throw new RuntimeException("Can't update task " + e.getMessage() + ". " + e.getCause());
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession().getSession()) {
            Task task = findById(id);

            if (task != null) {
                Transaction transaction = session.beginTransaction();
                Query query = session.createQuery("DELETE FROM Task task WHERE id = :taskId");
                query.setParameter("taskId", id);
                query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete task " + e.getMessage());
        }
    }
}
