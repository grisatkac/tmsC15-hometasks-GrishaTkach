package by.tms.tkach.pojo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = -7711524144457744125L;
    private OrderIdentity id;
    private String nameOfOrder;
    private Item item;

    public Order() {
        this.id = new OrderIdentity();
    }

    public Order(String nameOfOrder, Item item) {
        this();
        this.nameOfOrder = nameOfOrder;
        this.item = item;
    }

    public OrderIdentity getId() {
        return id;
    }

    public void setId(OrderIdentity id) {
        this.id = id;
    }

    public String getNameOfOrder() {
        return nameOfOrder;
    }

    public void setNameOfOrder(String nameOfOrder) {
        this.nameOfOrder = nameOfOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(nameOfOrder, order.nameOfOrder) && Objects.equals(item, order.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfOrder, item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nameOfOrder='" + nameOfOrder + '\'' +
                ", item=" + item +
                '}';
    }
}
