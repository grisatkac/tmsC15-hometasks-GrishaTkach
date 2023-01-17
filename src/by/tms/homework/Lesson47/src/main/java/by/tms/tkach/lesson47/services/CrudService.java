package by.tms.tkach.lesson47.services;

import java.util.List;

public interface CrudService<T> {

    T create(T value);
    List<T> findAll();
    T findById(Long id);
    T update(T value);
    void deleteById(Long id);
    void delete(T value);
}
