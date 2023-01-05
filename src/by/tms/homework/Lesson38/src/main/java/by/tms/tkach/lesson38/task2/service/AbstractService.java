package by.tms.tkach.lesson38.task2.service;

import by.tms.tkach.lesson38.task2.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> extends CrudService<T> {
}
