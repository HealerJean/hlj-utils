package com.hlj.util.Z010异常;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author HealerJean
 * @version 1.0v
 * @ClassName MainTest
 * @date 2019/5/30  16:25.
 * @Description
 */
@Slf4j
public class TestMain {


    /**
     * retCode:301----errMsg:null
     */
    @Test
    public void code(){
        try {
            throw new BusinessException(ResponseEnum.参数错误.getCode());
        }catch (BusinessException b){
            System.out.println("retCode:"+b.getCode() +"----errMsg:"+b.getMessage());
        }
    }

    /**
     * retCode:301----errMsg:异常信息
     */
    @Test
    public void message(){
        try {
            throw new BusinessException("异常信息");
        }catch (BusinessException b){
            System.out.println("retCode:"+b.getCode() +"----errMsg:"+b.getMessage());
        }
    }


    /**
     * retCode:1----errMsg:异常是1
     */
    @Test
    public void codeAndMessage(){
        try {
            throw new BusinessException(1,"异常是1");
        }catch (BusinessException b){
            System.out.println("retCode:"+b.getCode() +"----errMsg:"+b.getMessage());
        }
    }

    /**
     * retCode:400----errMsg:参数错误
     */
    @Test
    public void EnumTest(){
        try {
            throw new BusinessException(ResponseEnum.参数错误);
        }catch (BusinessException b){
            System.out.println("retCode:"+b.getCode() +"----errMsg:"+b.getMessage());
        }
    }

    /**
     *  retCode:1----errMsg:java.lang.ArithmeticException: / by zero
     */
    @Test
    public void codeAndException(){
        try {
            int i = 1/0 ;
        }catch (Exception e){
            try {
                throw new BusinessException(1,e);
            }catch (BusinessException b){
                System.out.println("retCode:"+b.getCode() +"----errMsg:"+b.getMessage());
            }
        }
    }

    /**
     * retCode:301----errMsg:异常信息 (默认提供了code)
     */
    @Test
    public void messageAndException(){
        try {
            int i = 1/0 ;
        }catch (Exception e){
            try {
                throw new BusinessException("异常信息",e);
            }catch (BusinessException b){
                System.out.println("retCode:"+b.getCode() +"----errMsg:"+b.getMessage());
            }
        }
    }


}
