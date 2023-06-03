package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @author Violet
 * @since 2023/6/3 12:30
 */
@Getter
@AllArgsConstructor
public enum OrderStateEnum {

    UNPAID("未支付", 0),
    PAID("已支付", 1),
    DELIVERED("已发货", 2),
    DONE("已妥投", 3),
    DELETED("已删除", 4);

    private final String name;
    private final int code;

}
