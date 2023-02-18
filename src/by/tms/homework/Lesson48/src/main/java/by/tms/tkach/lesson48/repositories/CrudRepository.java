package by.tms.tkach.lesson48.repositories;

import java.util.List;

public interface CrudRepository<T> {

    T save(T value);
    List<T> findAll();
    T findById(Long id);
    T update(T value);
    void delete(Long id);
}
