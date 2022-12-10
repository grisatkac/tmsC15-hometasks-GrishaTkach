package by.tms.helpdesk.lesson34.repositories;

import by.tms.helpdesk.lesson34.entities.AbstractEntity;
import java.util.List;

public interface CrudRepository<T extends AbstractEntity> {

    boolean add(T entity);

    T find(Long id);

    List<T> findAll();

    boolean update(T entity);

    boolean delete(Long id);
}
