package by.tms.tkach.lesson46.repositories.impl;

import by.tms.tkach.lesson46.entities.User;
import by.tms.tkach.lesson46.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    @Transactional
    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("SELECT user From User user");
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        Query query = entityManager.createQuery("SELECT user From User user WHERE user.id = :id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public User update(User user) {
        Query query = entityManager.createQuery("UPDATE User user SET user.firstName = :firstName, user.lastName = :lastName WHERE user.id = :id");
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        query.setParameter("id", user.getId());
        query.executeUpdate();
        return user;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User user WHERE user.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
