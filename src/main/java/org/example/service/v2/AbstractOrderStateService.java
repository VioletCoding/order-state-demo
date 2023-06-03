package org.example.service.v2;

import lombok.RequiredArgsConstructor;
import org.example.entity.OrderInfo;
import org.example.service.IOrderService;
import org.example.service.IOrderStateService;

/**
 * 订单状态服务抽象类
 *
 * @author Violet
 * @since 2023/6/3 13:29
 */
@RequiredArgsConstructor
public class AbstractOrderStateService implements IOrderStateService {

    protected final IOrderService orderService;

    @Override
    public boolean pay(OrderInfo orderInfo) {
        System.out.printf("订单：%d 状态：%s，无法支付%n", orderInfo.getId(), orderInfo.getState().getName());
        return false;
    }

    @Override
    public boolean reminder(OrderInfo orderInfo) {
        System.out.printf("订单：%d 状态：%s，无法催单%n", orderInfo.getId(), orderInfo.getState().getName());
        return false;
    }

    @Override
    public boolean delete(OrderInfo orderInfo) {
        System.out.printf("订单：%d 状态：%s，无法删除%n", orderInfo.getId(), orderInfo.getState().getName());
        return false;
    }
}
