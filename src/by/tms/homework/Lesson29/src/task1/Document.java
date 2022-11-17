package task1;

import task1.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Document implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 1100647774238909560L;
    private long id;
    private int number;
    private LocalDate date;
    private String ownerName;


    public Document(int number, LocalDate date, String ownerName) {
        this.id = IdentityUtil.generateDocumentId();
        this.number = number;
        this.date = date;
        this.ownerName = ownerName;
    }

    public Document(long id, int number, LocalDate date, String ownerName) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.ownerName = ownerName;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return id == document.id && number == document.number && Objects.equals(date, document.date) && Objects.equals(ownerName, document.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, date, ownerName);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    @Override
    protected Document clone() throws CloneNotSupportedException {
        return (Document)super.clone();
    }

    public static Document cloneDocument(Document document) {
        return new Document(document.getId(), document.getNumber(), document.getDate(), document.getOwnerName());
    }
}
