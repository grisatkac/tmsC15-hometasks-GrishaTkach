package by.tms.tkach.lesson39.task2.repository;

public interface CrudRepository <T> {

    Boolean add(T entity);
    Boolean update(T entity);
    Boolean delete(T entity);
}
