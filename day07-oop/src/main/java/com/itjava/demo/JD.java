package com.itjava.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JD implements Switch {
    private String name;
    private boolean status;

    @Override
    public void press() {
        //状态只有开和关，按一下改变状态，所以每次调用方法的时候直接让状态取反就行
        status = !status;
    }

}
