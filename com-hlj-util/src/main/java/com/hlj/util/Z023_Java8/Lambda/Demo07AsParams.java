package com.hlj.util.Z023_Java8.Lambda;

import org.junit.Test;

/**
 * @Desc: lambad ��Ϊ����
 * @Author HealerJean
 * @Date 2018/9/14  ����11:48.
 */
public class Demo07AsParams {

    @Test
    public void demo(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{

        });

    }
}
