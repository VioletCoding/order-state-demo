package org.example.service.v2;

import org.example.service.IOrderService;

/**
 * 已删除订单状态服务
 *
 * @author Violet
 * @since 2023/6/3 13:38
 */
public class DeletedOrderStateService extends AbstractOrderStateService {

    public DeletedOrderStateService(IOrderService orderService) {
        super(orderService);
    }

}
