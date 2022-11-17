package task1;

import task1.utils.DocumentUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        List<Document> documents = DocumentUtil.getDocuments();
        System.out.println(documents);

        Map<Integer, Document> mapWithoutRepeatedDocuments = DocumentUtil.getNotRepeatedDocuments();
        System.out.println(mapWithoutRepeatedDocuments);
    }
}
