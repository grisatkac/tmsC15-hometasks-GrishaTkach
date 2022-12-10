package by.tms.helpdesk.lesson34.services;

import by.tms.helpdesk.lesson34.entities.AbstractEntity;
import by.tms.helpdesk.lesson34.services.user.AccessUser;

public interface AbstractService<T extends AbstractEntity> extends CrudService<T> {
}
