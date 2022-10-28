package by.tms.tkach;

import by.tms.tkach.pojo.Item;
import by.tms.tkach.pojo.Order;
import by.tms.tkach.pojo.OrderList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderList {

    private static OrderList orderList;

    @BeforeAll
    public static void init() {
        orderList = new OrderList();
    }

    static Stream<Arguments> testAddOrderParams() {
        return Stream.of(
                Arguments.of(new Order("order", new Item("apples", 5, 5)), true),
                Arguments.of(null, false),
                Arguments.of(new Order("order", new Item("bananas", -5, 5)), false),
                Arguments.of(new Order("order", new Item("bananas", 5, -5)), false),
                Arguments.of(new Order("order", new Item("", 0, 5)), false),
                Arguments.of(new Order("order", null), false),
                Arguments.of(new Order("ax",  new Item("bananas", 10, 10)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testAddOrderParams")
    public void addOrder(Order order, boolean expectedResultOfAdding) {
        boolean resultOfAdding = orderList.addOrder(order);
        assertEquals(expectedResultOfAdding, resultOfAdding);
    }

    static  Stream<Arguments> testEqualsParams() {
        return Stream.of(
                Arguments.of(new OrderList(), new OrderList(), false),
                Arguments.of(null, new OrderList(), false),
                Arguments.of(new OrderList(), null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testEqualsParams")
    public void equals(OrderList first, OrderList second, boolean expectedResult) {
        boolean resultOfEqual;
        if (first == null) {
            resultOfEqual = false;
        } else {
            resultOfEqual = first.equals(second);
        }
        assertEquals(expectedResult, resultOfEqual);
    }
}