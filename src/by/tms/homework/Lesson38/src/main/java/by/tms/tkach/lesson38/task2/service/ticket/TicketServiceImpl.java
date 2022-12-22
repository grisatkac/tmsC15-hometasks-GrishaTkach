package by.tms.tkach.lesson38.task2.service.ticket;

//import by.tms.tkach.lesson38.task1.entity.ticket.Ticket;

import by.tms.tkach.lesson38.task2.entity.ticket.Ticket;
import by.tms.tkach.lesson38.task2.repository.ticket.TicketRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "ticketService")
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepositoryImpl ticketRepository;

    @Override
    public Ticket getById(Long id) {
        if (id == null) {
            log.info("Invalid id");
            return null;
        }

        Ticket resultOfGettingById = ticketRepository.find(id);
        log.info("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }
}
