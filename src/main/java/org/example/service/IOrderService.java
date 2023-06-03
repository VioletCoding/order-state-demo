package org.example.service;

import org.example.entity.OrderInfo;
import org.example.enums.OrderStateEnum;

/**
 * 订单抽象接口
 *
 * @author Violet
 * @since 2023/6/3 12:27
 */
public interface IOrderService {

    /**
     * 改变订单状态
     *
     * @param orderInfo 订单信息
     * @param newState     要改变的状态
     */
    void changeState(OrderInfo orderInfo, OrderStateEnum newState);

    /**
     * 支付订单
     *
     * @param orderInfo 订单信息
     * @return 是否成功
     */
    boolean pay(OrderInfo orderInfo);

    /**
     * 催单
     *
     * @param orderInfo 订单信息
     * @return 是否成功
     */
    boolean reminder(OrderInfo orderInfo);

    /**
     * 删除订单
     * @param orderInfo 订单信息
     * @return 是否成功
     */
    boolean delete(OrderInfo orderInfo);
}
