package org.example.entity;

import lombok.Data;
import org.example.enums.OrderStateEnum;

/**
 * 订单信息
 *
 * @author Violet
 * @since 2023/6/3 12:28
 */
@Data
public class OrderInfo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 订单状态
     */
    private OrderStateEnum state;

}
