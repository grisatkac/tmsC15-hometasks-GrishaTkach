package by.tms.tkach.lesson38.task2;

import by.tms.tkach.lesson38.task2.service.ticket.TicketService;
import by.tms.tkach.lesson38.task2.service.ticket.TicketServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("2applicationConfig.xml");
        TicketService ticketService = applicationContext.getBean("ticketService", TicketServiceImpl.class);
        System.out.println(ticketService.getById(2L));
    }
}
