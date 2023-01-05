package by.tms.tkach.lesson45.services;

import java.util.List;

public interface CrudService<T> {

    T create(T value);
    List<T> findAll();
    T findById(Long id);
    T update(T value);
    void delete(Long id);
}
