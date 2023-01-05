package by.tms.tkach.lesson44.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T create(T value);
    List<T> findAll();
    Optional<T> findById(Long id);
    T update(T value);
    void delete(Long id);
}
