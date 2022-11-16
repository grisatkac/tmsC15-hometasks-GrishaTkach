package by.tms.tkach.entities.ticket;

public interface Status {

    void makeTicketPending();
    void makeTicketInProgress();
    void makeTicketCompleted();
}
