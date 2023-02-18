package by.tms.tkach.utils;

import java.io.Serial;
import java.io.Serializable;

public class IdentityUtil implements Serializable {

    @Serial
    private static final long serialVersionUID = -7428168151629252996L;
    private static Long orderId = 1L;
    private static Long itemId = 1L;
    private static Long orderListId = 1L;

    public static Long generateOrderId() {
        return orderId++;
    }

    public static Long generateItemId() {
        return itemId++;
    }

    public static Long generateOrderListId() {
        return orderListId++;
    }

}
