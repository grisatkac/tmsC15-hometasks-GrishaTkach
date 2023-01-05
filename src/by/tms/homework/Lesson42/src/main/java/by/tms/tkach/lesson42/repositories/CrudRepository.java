package by.tms.tkach.lesson42.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T create(T value);
    List<T> findAll();
    Optional<T> findById(Long id);
}
