package by.tms.tkach.lesson38.task3.repository;

public interface CrudRepository <T> {

    boolean add(T entity);
    boolean update(T entity);
    boolean delete(T entity);
}
