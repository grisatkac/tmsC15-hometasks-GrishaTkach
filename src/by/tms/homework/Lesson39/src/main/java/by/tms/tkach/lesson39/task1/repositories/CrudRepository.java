package by.tms.tkach.lesson39.task1.repositories;

import by.tms.tkach.lesson39.task1.entities.AbstractEntity;
import java.util.List;

public interface CrudRepository<T extends AbstractEntity> {

    Boolean create(T entity);

    T findById(Long id);

    List<T> findAll();

    Boolean update(T entity);

    Boolean delete(Long id);
}
