package by.tms.tkach.repositories;

import java.util.List;

public interface CrudRepository<T> {

    boolean add(T entity);

    T find(long id);

    List<T> findAll();

    boolean update(T entity);

    boolean delete(long id);
}
