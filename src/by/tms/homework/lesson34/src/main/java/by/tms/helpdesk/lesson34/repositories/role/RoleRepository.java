package by.tms.helpdesk.lesson34.repositories.role;


import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.repositories.AbstractRepository;


public interface RoleRepository extends AbstractRepository<Role> {

    Role find(Role role);
}
