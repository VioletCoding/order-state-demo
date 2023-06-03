package org.example.service;

import org.example.entity.OrderInfo;

/**
 * 订单状态服务接口
 *
 * @author Violet
 * @since 2023/6/3 13:28
 */
public interface IOrderStateService {

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
     *
     * @param orderInfo 订单信息
     * @return 是否成功
     */
    boolean delete(OrderInfo orderInfo);

}
