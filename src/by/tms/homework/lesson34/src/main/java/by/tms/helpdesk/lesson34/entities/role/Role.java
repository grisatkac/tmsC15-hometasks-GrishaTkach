package by.tms.helpdesk.lesson34.entities.role;

import by.tms.helpdesk.lesson34.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Role extends AbstractEntity {

    RoleValues role;

    public Role(RoleValues role) {
        super();
        this.role = role;
    }

    public Role(Long id, RoleValues role) {
        super(id);
        this.role = role;
    }

    public String getRoleValue() {
        return role.getValue();
    }
}
