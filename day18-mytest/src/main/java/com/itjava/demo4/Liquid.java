package com.itjava.demo4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Liquid {
    private String name; // 名称
    private int volume; // 重量
    private int value; // 总价值
    // 计算每升的单价
    public double getOnePrice() {
        // 精确运算：BigDecimal
        BigDecimal value = BigDecimal.valueOf(this.value);
        BigDecimal volume = BigDecimal.valueOf(this.volume);
        return value.divide(volume,  2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}