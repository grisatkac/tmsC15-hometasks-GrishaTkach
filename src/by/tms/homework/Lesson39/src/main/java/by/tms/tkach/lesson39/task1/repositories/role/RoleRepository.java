package by.tms.tkach.lesson39.task1.repositories.role;

import by.tms.tkach.lesson39.task1.entities.role.Role;
import by.tms.tkach.lesson39.task1.repositories.AbstractRepository;

public interface RoleRepository extends AbstractRepository<Role> {

    Role find(Role role);
}
