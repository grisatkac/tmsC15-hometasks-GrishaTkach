package by.tms.homework.lesson11;

public class CustomUnCheckedException extends RuntimeException {

    public CustomUnCheckedException() {
    }

    public CustomUnCheckedException(String message) {
        super(message);
    }

    public CustomUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomUnCheckedException(Throwable cause) {
        super(cause);
    }
}
