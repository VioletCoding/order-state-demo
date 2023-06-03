package org.example.service.v2;

import org.example.entity.OrderInfo;
import org.example.enums.OrderStateEnum;
import org.example.service.IOrderService;

/**
 * 未支付订单状态服务
 *
 * @author Violet
 * @since 2023/6/3 13:32
 */
public class UnpaidOrderStateService extends AbstractOrderStateService {
    public UnpaidOrderStateService(IOrderService orderService) {
        super(orderService);
    }

    @Override
    public boolean pay(OrderInfo orderInfo) {
        this.orderService.changeState(orderInfo, OrderStateEnum.PAID);
        System.out.printf("订单：%d 状态：%s，支付成功%n", orderInfo.getId(), orderInfo.getState().getName());
        return true;
    }

    @Override
    public boolean delete(OrderInfo orderInfo) {
        this.orderService.changeState(orderInfo,OrderStateEnum.DELETED);
        System.out.printf("订单：%d 状态：%s，删除成功%n", orderInfo.getId(), orderInfo.getState().getName());
        return true;
    }
}
