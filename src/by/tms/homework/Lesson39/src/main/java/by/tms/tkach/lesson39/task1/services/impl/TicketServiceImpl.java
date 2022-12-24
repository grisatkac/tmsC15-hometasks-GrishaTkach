package by.tms.tkach.lesson39.task1.services.impl;

import by.tms.tkach.lesson39.task1.entities.ticket.Ticket;
import by.tms.tkach.lesson39.task1.repositories.ticket.TicketRepository;
import by.tms.tkach.lesson39.task1.services.ticket.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    TicketRepository ticketRepository;

    @Override
    public Boolean create(Ticket ticket) {
        boolean isTicketAdded = false;

        if (!checkValidParams(ticket)) {
            return false;
        }

        isTicketAdded = ticketRepository.create(ticket);
        return isTicketAdded;
    }

    @Override
    public Ticket getById(Long id) {
        if (id == null) {
            return null;
        }

        Ticket resultOfGettingById = ticketRepository.findById(id);
        return resultOfGettingById;
    }

    @Override
    public List<Ticket> getByStatus(Long userId, String status) {
        List<Ticket> foundTickets = null;
        if (userId != null || status != null || !status.isEmpty()) {
            foundTickets = ticketRepository.findByStatus(userId, status);
        }

        return foundTickets;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Boolean update(Ticket ticket) {
        boolean resultOfUpdating = false;

        if (!checkValidParams(ticket)) {
            return resultOfUpdating;
        }

        ticket.setId(ticket.getId());
        resultOfUpdating = ticketRepository.update(ticket);
        return resultOfUpdating;
    }

    @Override
    public Boolean delete(Long id) {
        boolean resultOfDeleting = false;

        if (id == null) {
            return resultOfDeleting;
        }

        resultOfDeleting = ticketRepository.delete(id);
        return resultOfDeleting;
    }

    private boolean checkValidParams(Ticket ticket) {
        if (ticket == null) {
            return false;
        }

        if (ticket.getTitle() == null || ticket.getDescription() == null || ticket.getStatus() == null) {
            return false;
        }

        if (ticket.getTitle().isEmpty() || ticket.getDescription().isEmpty() || ticket.getStatus().getValue().isEmpty()) {
            return false;
        }

        return true;
    }
}
