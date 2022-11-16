package by.tms.tkach.entities.user;

import lombok.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class User extends UserIdentity implements Serializable, Workable, Cloneable {

    @Serial
    private static final long serialVersionUID = 6663698300936958977L;
    private static final int maxAmountOfTickets = 5;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private boolean canDoJob;

    public User(String name, String surname, String email, String login, String password, boolean canDoJob) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.canDoJob = canDoJob;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public boolean canDoWork() {
        return canDoJob;
    }

    @Override
    public void makeUserCanDoJob() {
        this.canDoJob = true;
    }

    @Override
    public void makeUserNotCanDoJob() {
        this.canDoJob = false;
    }
}
