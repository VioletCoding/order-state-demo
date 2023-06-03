package org.example;

import org.example.entity.OrderInfo;
import org.example.enums.OrderStateEnum;
import org.example.service.IOrderService;
import org.example.service.v1.OrderServiceV1;
import org.example.service.v2.OrderServiceV2;

import java.util.Random;

/**
 * @author Violet
 * @since 2023/6/3 12:45
 */
public class Main {
    private static final OrderInfo orderInfo = new OrderInfo();

    static {
        orderInfo.setId(new Random().nextLong());
        orderInfo.setState(OrderStateEnum.UNPAID);
    }

    public static void main(String[] args) {
        // v1();
        v2();
    }

    public static void v1() {
        IOrderService v1 = new OrderServiceV1();
        v1.reminder(orderInfo);

        v1.pay(orderInfo);
        v1.reminder(orderInfo);
    }

    public static void v2() {
        OrderServiceV2 v2 = new OrderServiceV2();
        v2.reminder(orderInfo);
        v2.pay(orderInfo);
        v2.reminder(orderInfo);

        v2.pay(orderInfo);
        v2.delete(orderInfo);
    }


}
