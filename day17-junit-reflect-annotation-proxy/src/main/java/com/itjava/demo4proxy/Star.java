package com.itjava.demo4proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Star implements StarService{
    private String name;


    @Override
    public void sing() {
        System.out.println(this.name+"唱歌");
    }

    @Override
    public String dance(String danceName) {
        System.out.println(this.name+danceName);
        return "跳舞";
    }
}
