package com.itjava.demo4test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String size;  //数字
    private String color; //花色
    private int level;    //牌的等级

    @Override
    public String toString() {
        return size + color;
    }
}
