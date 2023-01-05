package by.tms.tkach.lesson39.task1.repositories;

import by.tms.tkach.lesson39.task1.entities.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity> extends CrudRepository<T> {
}
