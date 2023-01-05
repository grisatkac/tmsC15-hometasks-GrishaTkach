package by.tms.tkach.lesson39.task1.services;

import by.tms.tkach.lesson39.task1.entities.AbstractEntity;

import java.util.List;

public interface CrudService<T extends AbstractEntity> {

    Boolean create(T entity);

    T getById(Long id);

    List<T> getAll();

    Boolean update(T entity);

    Boolean delete (Long id);
}
