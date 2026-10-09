package com.itjava.demo3annotation;

public @interface A {

    String value(); //特殊属性,在使用时如果只有一个value属性,,则value名称可以不写
    String hobby() default "看书";  //有别的属性时,如果别的属性有默认值也可以不写value
}
