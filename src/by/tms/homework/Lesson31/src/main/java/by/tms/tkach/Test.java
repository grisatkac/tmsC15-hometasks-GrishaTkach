package by.tms.tkach;

import by.tms.tkach.pojo.Item;
import by.tms.tkach.pojo.Order;
import by.tms.tkach.pojo.OrderList;
import by.tms.tkach.utils.LogUtil;

public class Test {

    public static void main(String[] args) {
        LogUtil.printInfoLog("Start work program");
        Order order = new Order("first order", new Item("apples", 10, 10));
        Order order1 = new Order("", new Item("bananas", -5, 4));
        OrderList orderList = new OrderList();
        orderList.addOrder(order);
        orderList.addOrder(order1);
        LogUtil.printInfoLog("End work program");

    }
}
