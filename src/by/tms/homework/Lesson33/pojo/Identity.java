package by.tms.homework.Lesson33.pojo;

import by.tms.homework.Lesson33.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;

public class Identity implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 4973758404125910218L;
    private long id;

    public Identity() {
        this.id = IdentityUtil.generateUserId();
    }

    public Identity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("Class: %s \n id this user: %s", getClass().getSimpleName(), id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Identity identity = (Identity)obj;
        return this.id == identity.getId();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id) * 29;
    }
}
