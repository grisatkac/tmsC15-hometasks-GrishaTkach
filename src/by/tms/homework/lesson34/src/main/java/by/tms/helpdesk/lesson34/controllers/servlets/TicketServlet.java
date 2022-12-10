package by.tms.helpdesk.lesson34.controllers.servlets;

import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.ticket.TicketService;
import by.tms.helpdesk.lesson34.services.ticket.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "tickets", urlPatterns = {"/tickets", "/tickets/pending", "/tickets/performs", "/tickets/completed"})
public class TicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketService ticketService = new TicketServiceImpl();
        List<Ticket> tickets = ticketService.getAll();
        request.setAttribute("tickets", tickets);

        request.getRequestDispatcher(  "tickets.jsp").forward(request,response);
    }
}
