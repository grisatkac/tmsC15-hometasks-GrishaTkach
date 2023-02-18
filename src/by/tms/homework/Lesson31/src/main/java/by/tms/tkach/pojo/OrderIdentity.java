package by.tms.tkach.pojo;

import by.tms.tkach.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class OrderIdentity implements Serializable {

    @Serial
    private static final long serialVersionUID = 6548184724054242284L;
    private Long id;

    public OrderIdentity() {
        this.id = IdentityUtil.generateOrderId();
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
        if (!(o instanceof OrderIdentity)) return false;
        OrderIdentity that = (OrderIdentity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderIdentity{" +
                "id=" + id +
                '}';
    }
}
