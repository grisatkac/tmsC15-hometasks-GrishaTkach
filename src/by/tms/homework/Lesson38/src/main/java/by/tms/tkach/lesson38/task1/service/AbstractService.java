package by.tms.tkach.lesson38.task1.service;

import by.tms.tkach.lesson38.task1.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> extends CrudService<T> {
}
