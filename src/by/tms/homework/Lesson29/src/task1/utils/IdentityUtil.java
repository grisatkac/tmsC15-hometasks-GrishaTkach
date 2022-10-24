package task1.utils;

public class IdentityUtil {

    private static long documentId = 1L;

    public IdentityUtil() {}

    public static long generateDocumentId() {
        return documentId++;
    }
}
