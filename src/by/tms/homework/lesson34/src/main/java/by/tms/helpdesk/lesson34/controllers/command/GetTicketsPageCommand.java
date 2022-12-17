package by.tms.helpdesk.lesson34.controllers.command;

import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.services.ticket.TicketService;
import by.tms.helpdesk.lesson34.services.ticket.TicketServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class GetTicketsPageCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        TicketService ticketService = new TicketServiceImpl();
        List<Ticket> tickets = ticketService.getAll();
        request.setAttribute("tickets", tickets);
        request.getRequestDispatcher(  "tickets.jsp").forward(request,response);
    }
}
