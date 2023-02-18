package by.tms.tkach.pojo;

import by.tms.tkach.utils.LogUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderList implements Serializable {

    @Serial
    private static final long serialVersionUID = 5142792839655665298L;
    private OrderListIdentity id;
    private List<Order> orderList;

    public OrderList() {
        this.id = new OrderListIdentity();
        this.orderList = new ArrayList<>();
    }

    public boolean addOrder(Order order) {
        boolean isAddedOrder = false;
        if (order == null || order.getNameOfOrder().length() < 4 || order.getItem() == null) {
            LogUtil.printInfoLog("Incorrect name of order");
            return isAddedOrder;
        }

        if (order.getItem().getAmount() < 1 || order.getItem().getPrice() <= 0 ||
                order.getItem().getNameOfItem().isEmpty()) {
            LogUtil.printInfoLog("Incorrect fields of item");
            return isAddedOrder;
        }

        orderList.add(order);
        isAddedOrder = true;
        LogUtil.printInfoLog("Adding order was successful");
        return isAddedOrder;
    }

    public  List<Order> getOrderList() {
        return this.orderList;
    }

    public  void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderList)) return false;
        OrderList orderList = (OrderList) o;
        return Objects.equals(id, orderList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "id=" + id +
                ", orderList=" + orderList +
                '}';
    }
}
