package org.example.service.v1;

import org.example.entity.OrderInfo;
import org.example.enums.OrderStateEnum;
import org.example.service.IOrderService;

/**
 * 订单实现类V1版本
 *
 * @author Violet
 * @since 2023/6/3 12:33
 */

public class OrderServiceV1 implements IOrderService {

    @Override
    public void changeState(OrderInfo orderInfo, OrderStateEnum newState) {
        System.out.printf("订单%d状态：由%s转变为%s%n",
                orderInfo.getId(),
                orderInfo.getState().getName(),
                newState.getName()
        );
        orderInfo.setState(newState);
    }

    @Override
    public boolean pay(OrderInfo orderInfo) {
        if (orderInfo.getState() == OrderStateEnum.UNPAID) {
            changeState(orderInfo, OrderStateEnum.PAID);
            System.out.printf("订单%d支付成功%n", orderInfo.getId());
            return true;
        }
        System.out.printf("订单%d支付失败%n", orderInfo.getId());
        return false;
    }

    @Override
    public boolean reminder(OrderInfo orderInfo) {
        switch (orderInfo.getState()) {
            case PAID, DELIVERED -> {
                System.out.printf("订单%d催单成功%n", orderInfo.getId());
                return true;
            }
        }
        System.out.printf("订单%d催单失败%n", orderInfo.getId());
        return false;
    }

    @Override
    public boolean delete(OrderInfo orderInfo) {
        switch (orderInfo.getState()) {
            case UNPAID, DONE -> {
                changeState(orderInfo, OrderStateEnum.DELETED);
                System.out.printf("订单%d删除成功%n", orderInfo.getId());
                return true;
            }
        }
        System.out.printf("订单%d删除失败%n", orderInfo.getId());
        return false;
    }
}
