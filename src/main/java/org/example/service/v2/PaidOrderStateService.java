package org.example.service.v2;

import org.example.entity.OrderInfo;
import org.example.service.IOrderService;

/**
 * 已支付订单状态服务
 *
 * @author Violet
 * @since 2023/6/3 13:36
 */
public class PaidOrderStateService extends AbstractOrderStateService {

    public PaidOrderStateService(IOrderService orderService) {
        super(orderService);
    }

    @Override
    public boolean reminder(OrderInfo orderInfo) {
        System.out.printf("订单：%d 状态：%s，催单成功%n", orderInfo.getId(), orderInfo.getState().getName());
        return true;
    }
}
