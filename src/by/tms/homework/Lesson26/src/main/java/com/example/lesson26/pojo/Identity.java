package com.example.lesson26.pojo;

import com.example.lesson26.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;

public class Identity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3751679769830648515L;

    private long id;

    public Identity() {
        this.id = IdentityUtil.generateUserId();
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
