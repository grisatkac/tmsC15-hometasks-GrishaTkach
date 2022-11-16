package by.tms.tkach.entities.user;

import by.tms.tkach.utils.identity.IdentityUtils;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserIdentity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3515618503956270601L;
    private long id;

    public UserIdentity() {
        this.id = IdentityUtils.generateUserId();
    }
}
