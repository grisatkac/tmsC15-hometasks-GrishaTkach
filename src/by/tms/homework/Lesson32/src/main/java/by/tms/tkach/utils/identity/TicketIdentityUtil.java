package by.tms.tkach.utils.identity;

public class TicketIdentityUtil {

    public static long ticket_id = 1L;

    public TicketIdentityUtil() {};

    public static long generateId() {
        return ticket_id++;
    }

    public static void decrementId() {
        ticket_id--;
    }
}
