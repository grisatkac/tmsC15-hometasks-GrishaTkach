package by.tms.tkach;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.services.ticket.TicketServiceImpl;
import by.tms.tkach.services.user.UserServiceImpl;


public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        TicketServiceImpl ticketService = new TicketServiceImpl();
        addNewUser(userService);
        getUserById(userService, 10L);
        deleteUserById(userService);
        updateUser(userService);
        addNewTicket(ticketService);
        getTicketById(ticketService, 2L);
        updateTicket(ticketService);
        deleteTicketById(ticketService);
    }

    public static void addNewUser(UserServiceImpl userService) {
        String name = "newName";
        String surname = "newSurname";
        String email = "newEmail";
        String login = "newLogin";
        String password = "newPassword";
        boolean canDoJob = true;

        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .login(login)
                .password(password)
                .canDoJob(canDoJob)
                .build();

        userService.create(name, surname, email, login, password, canDoJob);
    }

    public static void getAllUsers(UserServiceImpl userService) {
        System.out.println(userService.getAll());
    }

    public static void getUserById(UserServiceImpl userService, long userId) {
        User user = userService.getById(userId);
        System.out.println("found user: ");
        System.out.println(user);
    }

    public static void updateUser(UserServiceImpl userService) {
        long id = 2;
        String name = "name2";
        String surname = "updatedSurname";
        String email = "user2@gmail.com";
        String login = "updatedLogin";
        String password = "password2";
        boolean canDoJob = true;


        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .login(login)
                .password(password)
                .canDoJob(canDoJob)
                .build();
        user.setId(id);
        userService.update(user, id);
    }

    public static void deleteUserById(UserServiceImpl userService) {
        long idForDeleting = 3;
        userService.delete(idForDeleting);
    }

    public static void addNewTicket(TicketServiceImpl ticketService) {
        String title = "newTitle";
        String description = "newDescription";
        StatusType status = StatusType.IN_PROGRESS;
        User owner = null;
        User executor = null;
        ticketService.create(title, description, status, owner, executor);
    }

    public static void getAllTickets(TicketServiceImpl ticketService) {
        System.out.println(ticketService.getAll());
    }

    public static void getTicketById(TicketServiceImpl ticketService, long userId) {
        Ticket user = ticketService.getById(userId);
        System.out.println("found user: ");
        System.out.println(user);
    }

    public static void updateTicket(TicketServiceImpl ticketService ) {
        long id = 2;
        String title = "updatedTitle";
        String description = "updatedDescription";
        StatusType status = StatusType.IN_PROGRESS;
        User owner = null;
        User executor = null;


        Ticket ticket = Ticket.builder()
                .title(title)
                .description(description)
                .status(status)
                .owner(owner)
                .executor(executor)
                .build();
        ticket.setId(id);
        ticketService.update(ticket, id);
    }

    public static void deleteTicketById(TicketServiceImpl ticketService) {
        long idForDeleting = 3;
        ticketService.delete(idForDeleting);
    }
}