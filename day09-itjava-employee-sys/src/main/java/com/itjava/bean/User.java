package com.itjava.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//昵称，密码，登录名
public class User {
    private String name;
    private String password;
    private String loginName;
}
