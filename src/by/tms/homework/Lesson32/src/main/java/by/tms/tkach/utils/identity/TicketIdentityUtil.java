package by.tms.tkach.utils.identity;

public class TicketIdentityUtil {

    public static long ticketId = 1L;

    public TicketIdentityUtil() {};

    public static long generateId() {
        return ticketId++;
    }

    public static void decrementId() {
        ticketId--;
    }
}
