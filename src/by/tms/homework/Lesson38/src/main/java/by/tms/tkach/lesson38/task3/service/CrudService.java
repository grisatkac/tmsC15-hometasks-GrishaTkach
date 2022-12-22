package by.tms.tkach.lesson38.task3.service;

public interface CrudService<T> {

    boolean add(T entity);
    boolean update(T entity);
    boolean delete(T entity);
}
