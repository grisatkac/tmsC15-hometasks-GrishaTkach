package by.tms.tkach.lesson39.task2.service;

public interface CrudService<T> {

    Boolean add(T entity);
    Boolean update(T entity);
    Boolean delete(T entity);
}
