package by.tms.helpdesk.lesson34.repositories;

import by.tms.helpdesk.lesson34.entities.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity> extends Repository<T>, CrudRepository<T> {
}
