package by.tms.tkach.lesson38.task2.service;

// import by.tms.tkach.lesson38.task1.entity.AbstractEntity;

import by.tms.tkach.lesson38.task2.entity.AbstractEntity;

public interface CrudService<T extends AbstractEntity> {

    T getById(Long id);
}
