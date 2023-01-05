package by.tms.tkach.lesson38.task1.repository;

import by.tms.tkach.lesson38.task1.entity.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity> extends CrudRepository<T> {
}
