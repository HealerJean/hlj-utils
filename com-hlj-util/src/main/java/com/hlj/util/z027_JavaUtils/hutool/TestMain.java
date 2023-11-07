package com.hlj.util.z027_JavaUtils.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * TestMain
 *
 * @author zhangyujin
 * @date 2023/8/18
 */
public class TestMain {

    /**
     * 脱敏
     * 1、手机号 输出：137****1234
     * 2、银行卡号 输出：6217 **** **** *** 5666
     * 3、身份证号 输出：4110************21
     * 4、密码 输出：****************
     * 5、邮箱 输出：h*********@gmail.com
     * 6、地址 输出：我********
     * 7、脱敏任意长度 输出：我********
     *
     */
    @Test
    public void test01() {
        // 1、手机号 输出：137****1234
        String phone = "13723231234";
        System.out.println(DesensitizedUtil.mobilePhone(phone));

        // 2、银行卡号 输出：6217 **** **** *** 5666
        String bankCard = "6217000130008255666";
        System.out.println(DesensitizedUtil.bankCard(bankCard));

        // 3、身份证号 输出：4110************21
        String idCardNum = "411021199901102321";
        //只显示前4位和后2位
        System.out.println(DesensitizedUtil.idCardNum(idCardNum, 4, 2));

        // 4、密码 输出：****************
        String password = "www.jd.com_35711";
        System.out.println(DesensitizedUtil.password(password));

        // 5、邮箱 输出：h*********@gmail.com
        String email = "healerjean@gmail.com";
        System.out.println(DesensitizedUtil.email(email));

        // 6、地址 输出：我********
        String address = "我家在那山沟沟里面";
        String desensitizedAddress = DesensitizedUtil.desensitized(address, DesensitizedUtil.DesensitizedType.ADDRESS);
        System.out.println(desensitizedAddress);

        // 7、脱敏任意长度 输出：我********
        String any ="1234567890";
        System.out.println(StrUtil.hide(any, 2, 7));
    }


    /**
     * StrUtil
     * 1、StrUtil.format.
     */
    @Test
    public void test001(){
        String result = StrUtil.format("Hello, {0}", "world");
        System.out.println(result);
        // 输出：Hello, world
    }


    /**
     * DateUtil
     * 1、DateUtil.format、DateUtil.parse
     */
    @Test
    public void test101() {
        Date date = new Date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(format);
        // 输出：2023-03-15 10:30:15

        String dateStr = "2023-03-15 10:30:15";
        date = DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        // 输出：Tue Mar 15 10:30:15 CST 2023`

        DateUtil.offsetSecond(new Date(), 1);
    }


    /**
     * NumberUtil
     */
    @Test
    public void test201(){
        NumberUtil.div(new BigDecimal("1"), new BigDecimal("2"),2, RoundingMode.UP);
    }



}
