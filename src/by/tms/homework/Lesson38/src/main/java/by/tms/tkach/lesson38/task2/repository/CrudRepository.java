package by.tms.tkach.lesson38.task2.repository;

//import by.tms.tkach.lesson38.task1.entity.AbstractEntity;

import by.tms.tkach.lesson38.task2.entity.AbstractEntity;

public interface CrudRepository<T extends AbstractEntity> {

    T find(Long id);
}
