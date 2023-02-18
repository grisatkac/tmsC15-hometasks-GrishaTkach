package by.tms.tkach.pojo;

import by.tms.tkach.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ItemIdentity implements Serializable {
    @Serial
    private static final long serialVersionUID = -4900698102450093648L;
    private Long id;

    public ItemIdentity() {
        this.id = IdentityUtil.generateItemId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemIdentity)) return false;
        ItemIdentity that = (ItemIdentity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ItemIdentity{" +
                "id=" + id +
                '}';
    }
}
