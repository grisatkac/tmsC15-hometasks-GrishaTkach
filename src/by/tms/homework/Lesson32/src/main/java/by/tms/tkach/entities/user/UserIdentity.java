package by.tms.tkach.entities.user;

import by.tms.tkach.utils.identity.IdentityUtils;
import lombok.Data;

@Data
public class UserIdentity {

    private long id;

    public UserIdentity() {
        this.id = IdentityUtils.generateUserId();
    }
}
