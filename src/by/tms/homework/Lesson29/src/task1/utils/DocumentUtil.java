package task1.utils;

import task1.Document;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DocumentUtil {

    private static final List<Document> documents = new ArrayList<>();

    private DocumentUtil() {}

    public static List<Document> getDocuments() throws IOException {
        File file = Paths.get("resources", "task1", "documents.txt").toFile();
        if (file != null && file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
            readDocumentsFromFile(file);
        } else if (file.getName().endsWith(".txt")) {
            writeDocumentsInFile(file);
            readDocumentsFromFile(file);
        }

        return documents;
    }

    public static Map<Integer, Document> getNotRepeatedDocuments() {
        return documents.stream()
                .collect(Collectors.groupingBy(Document::getNumber, Collectors.toList()))
                .entrySet().stream()
                .filter(value -> value.getValue().size() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().get(0)));
    }

    public static List<Document> generateDocuments() {
        List<Document> documentList = new ArrayList<>();
        documentList.add(new Document(100, LocalDate.now(), "Alex"));
        documentList.add(new Document(200, LocalDate.now(), "Ivan"));
        documentList.add(new Document(300, LocalDate.now(), "Pavel"));
        documentList.add(new Document(300, LocalDate.now(), "Max"));
        documentList.add(new Document(400, LocalDate.now(), "Anton"));
        return documentList;
    }

    private static void readDocumentsFromFile(File file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    documents.add((Document) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void writeDocumentsInFile(File file) throws IOException {
        file.getParentFile().mkdirs();
        System.out.println("write in file");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            file.createNewFile();
            List<Document> documentList = generateDocuments();

            for (Document document : documentList) {
                outputStream.writeObject(document);
            }
        } catch (IOException e) {
            throw new IOException();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }
}
