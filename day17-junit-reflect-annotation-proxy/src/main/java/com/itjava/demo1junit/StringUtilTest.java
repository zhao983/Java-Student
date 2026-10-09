package com.itjava.demo1junit;

import org.junit.Assert;
import org.junit.Test;

//测试类：jUnit单元测试框架，对业务类中的业务方法进行正确性测试
public class StringUtilTest {
    //测试方法必须是公开的，无返回值
    //测试方法必须加上@Test注解
    @Test
    public void testPrintNumber() {
        //测试步骤
        StringUtil.printNumber("张三");
        //测试用例
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }

    @Test
    public void testGetMaxIndex() {
        // 测试步骤:
        int index = StringUtil.getMaxIndex("abcdefg"); // 5
        // 测试用例
        int index2 = StringUtil.getMaxIndex("");
        int index3 = StringUtil.getMaxIndex(null);
        //                                               三个参数
        //做断言，断言结果与预期是否一致    错误输出信息          预期结果   实际结果
        Assert.assertEquals("输出结果与预期不符合!",6,index);
    }

}
