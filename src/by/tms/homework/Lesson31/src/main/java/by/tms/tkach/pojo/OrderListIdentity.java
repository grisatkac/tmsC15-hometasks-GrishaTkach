package by.tms.tkach.pojo;

import by.tms.tkach.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class OrderListIdentity implements Serializable {
    @Serial
    private static final long serialVersionUID = -4261385051530072907L;
    private Long id;

    public OrderListIdentity() {
        this.id = IdentityUtil.generateOrderListId();
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
        if (!(o instanceof OrderListIdentity)) return false;
        OrderListIdentity that = (OrderListIdentity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderListIdentity{" +
                "id=" + id +
                '}';
    }
}
