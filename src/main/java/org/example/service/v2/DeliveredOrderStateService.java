package org.example.service.v2;

import org.example.entity.OrderInfo;
import org.example.service.IOrderService;

/**
 * 已发货订单状态服务
 *
 * @author Violet
 * @since 2023/6/3 13:37
 */
public class DeliveredOrderStateService extends AbstractOrderStateService {

    public DeliveredOrderStateService(IOrderService orderService) {
        super(orderService);
    }

    @Override
    public boolean reminder(OrderInfo orderInfo) {
        System.out.printf("订单：%d 状态：%s，催单成功%n", orderInfo.getId(), orderInfo.getState().getName());
        return true;
    }
}
