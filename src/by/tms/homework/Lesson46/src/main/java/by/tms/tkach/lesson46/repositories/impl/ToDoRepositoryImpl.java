package by.tms.tkach.lesson46.repositories.impl;

import by.tms.tkach.lesson46.entities.Task;
import by.tms.tkach.lesson46.repositories.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ToDoRepositoryImpl implements ToDoRepository {

    public EntityManager entityManager;

    @Override
    public Task create(Task task) {
        entityManager.persist(task);
        return task;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Task> findAll() {
        Query taskQueryResponse = entityManager.createQuery("SELECT task from Task task");
        return (List<Task>) taskQueryResponse.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Task> findById(Long id) {
        Query taskQueryResponse = entityManager.createQuery("SELECT task FROM Task task WHERE task.id = :id");
        taskQueryResponse.setParameter("id", id);
        return Optional.ofNullable((Task)taskQueryResponse.getSingleResult());
    }

    @Transactional
    @Override
    public Task update(Task task) {
        Query updateTaskQuery = entityManager.createQuery(
                "UPDATE Task task SET task.title = :title," +
                        " task.description = :description," +
                        " task.status = :status " +
                        "WHERE task.id = :id"
        );
        updateTaskQuery.setParameter("title", task.getTitle());
        updateTaskQuery.setParameter("description", task.getDescription());
        updateTaskQuery.setParameter("status", task.getStatus());
        updateTaskQuery.setParameter("id", task.getId());
        updateTaskQuery.executeUpdate();

        return task;
    }

    @Override
    public Task updateTitle(Task task) {
        Query query = entityManager.createQuery("UPDATE Task task SET task.title = :title");
        query.setParameter("title", task.getTitle());
        query.executeUpdate();
        return task;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Query deleteTaskQuery = entityManager.createQuery("DELETE FROM Task task WHERE task.id = :id");
        deleteTaskQuery.setParameter("id", id);
        deleteTaskQuery.executeUpdate();
    }
}
