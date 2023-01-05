package by.tms.tkach.lesson39.task1.services;

import by.tms.tkach.lesson39.task1.entities.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> extends CrudService<T> {
}
