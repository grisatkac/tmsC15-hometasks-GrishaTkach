package by.tms.helpdesk.lesson34.services;

import by.tms.helpdesk.lesson34.entities.AbstractEntity;

import java.util.List;

public interface CrudService<T extends AbstractEntity> {

    boolean create(T entity);

    T getById(Long id);

    List<T> getAll();

    boolean update(T entity);

    boolean delete (Long id);
}
