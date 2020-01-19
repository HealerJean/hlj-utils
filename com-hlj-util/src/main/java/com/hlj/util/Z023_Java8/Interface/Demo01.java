package com.hlj.util.Z023_Java8.Interface;

import com.hlj.util.Z023_Java8.Interface.Demo03InterfaceDefaultPack.MyInterface;
import com.hlj.util.Z023_Java8.Interface.Demo03InterfaceDefaultPack.impl.MyInterfaceImpl;
import org.junit.Test;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/9/14  ����11:48.
 */
public class Demo01 {

    @Test
    public void demo(){

        MyInterface myInterface = new MyInterfaceImpl() ;

        /**
         *  ���Ƿ�����������Ĭ�Ϸ��������԰����Ǽ̳���ȥ������Ҳ���Զ�����������и�����д
         */
        myInterface.methodNew();

        MyInterface.methodStatic();


    }
}
