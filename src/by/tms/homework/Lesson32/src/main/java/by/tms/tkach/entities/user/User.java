package by.tms.tkach.entities.user;

import by.tms.tkach.utils.identity.IdentityUtils;
import lombok.*;

@Data
@Builder
public class User implements  Cloneable {

    private static final int maxAmountOfTickets = 5;
    private long id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private boolean canDoJob;

    public User(String name, String surname, String email, String login, String password, boolean canDoJob) {
        this.id = IdentityUtils.generateUserId();
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
}
