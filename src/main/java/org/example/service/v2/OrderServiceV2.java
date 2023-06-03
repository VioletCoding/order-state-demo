package org.example.service.v2;

import org.example.entity.OrderInfo;
import org.example.enums.OrderStateEnum;
import org.example.service.IOrderService;
import org.example.service.IOrderStateService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 订单业务实现类V2
 *
 * @author Violet
 * @since 2023/6/3 13:41
 */
public class OrderServiceV2 implements IOrderService {

    private static final Map<Integer, IOrderStateService> stateImplMapping = new ConcurrentHashMap<>();

    public OrderServiceV2() {
        stateImplMapping.put(OrderStateEnum.UNPAID.getCode(), new UnpaidOrderStateService(this));
        stateImplMapping.put(OrderStateEnum.PAID.getCode(), new PaidOrderStateService(this));
        stateImplMapping.put(OrderStateEnum.DELIVERED.getCode(), new DeliveredOrderStateService(this));
        stateImplMapping.put(OrderStateEnum.DELETED.getCode(), new DeletedOrderStateService(this));
    }

    private IOrderStateService getOrderStateService(OrderInfo orderInfo) {
        IOrderStateService service = stateImplMapping.get(orderInfo.getState().getCode());
        if (service != null) {
            return service;
        }
        throw new UnsupportedOperationException("不支持的订单状态：" + orderInfo.getState().getName());
    }

    @Override
    public void changeState(OrderInfo orderInfo, OrderStateEnum newState) {
        System.out.printf("订单：%d 状态：由%s转变为%s%n",
                orderInfo.getId(),
                orderInfo.getState().getName(),
                newState.getName()
        );
        orderInfo.setState(newState);
    }

    @Override
    public boolean pay(OrderInfo orderInfo) {
        return getOrderStateService(orderInfo).pay(orderInfo);
    }

    @Override
    public boolean reminder(OrderInfo orderInfo) {
        return getOrderStateService(orderInfo).reminder(orderInfo);
    }

    @Override
    public boolean delete(OrderInfo orderInfo) {
        return getOrderStateService(orderInfo).delete(orderInfo);
    }
}
