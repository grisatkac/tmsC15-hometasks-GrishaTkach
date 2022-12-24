package by.tms.tkach.lesson39.task1;

import by.tms.tkach.lesson39.task1.services.ticket.TicketService;
import by.tms.tkach.lesson39.task1.services.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.tms.tkach.lesson39.task1");
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        userService.getAll();
        TicketService ticketService = applicationContext.getBean("ticketServiceImpl", TicketService.class);
        ticketService.getById(2L);
    }

}
