package by.tms.tkach.services;

import java.util.List;

public interface Service<T> {

    boolean create(T entity);

    T getById(long id);

    List<T> getAll();

    boolean update(T entity, long id);

    boolean delete (long id);
}
