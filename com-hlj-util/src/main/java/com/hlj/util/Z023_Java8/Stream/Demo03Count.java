package com.hlj.util.Z023_Java8.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: ͳ��stream ִ�н���ĸ���
 * @Author HealerJean
 * @Date 2018/9/14  ����11:48.
 */
public class Demo03Count {

    @Test
    public void count(){
        List<String> list = new ArrayList<>();
        list.add("HeallerJean");
        list.add("zhangyujin");
        list.add("zhaochunyu");
        list.add("lintie");
        list.add("buzhidao");
        list.add("ab"); //�ǹ�

        Long count =  list.stream().filter(s->s.length()<=2).map(s->s+"123").count();



    }
}
