package by.tms.tkach.lesson38.task1.entity.user;

import by.tms.tkach.lesson38.task1.entity.AbstractEntity;
import by.tms.tkach.lesson38.task1.entity.role.Role;
import by.tms.tkach.lesson38.task1.entity.ticket.Ticket;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class User extends AbstractEntity implements Cloneable {

    private static final int maxAmountOfTickets = 5;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean canDoJob;
    private Role role;
    private List<Ticket> tickets;

    public User(String name, String surname, String email, String password, boolean canDoJob, Role role, List<Ticket> tickets) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.canDoJob = canDoJob;
        this.role = role;
        this.tickets = tickets;
    }

    public User(Long id, String name, String surname, String email, String password, boolean canDoJob, Role role, List<Ticket> tickets) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.canDoJob = canDoJob;
        this.role = role;
        this.tickets = tickets;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
