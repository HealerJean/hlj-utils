package com.hlj.util.Z023_Java8.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: anyMatch ƥ����һԪ�� allMatchƥ������Ԫ�� noneMatch ��ƥ�������Ԫ��
 *          ����ֵ Ϊtrue false
 * @Author HealerJean
 * @Date 2018/9/14  ����11:48.
 */
public class Demo14AnyMatch {

    @Test
    public void demo(){
        List<String> list = new ArrayList<>();
        list.add("����ӱ");
        list.add("�����");
        list.add("�Դ���");
        list.add("����");
        list.add("�Ŵ�");
        list.add("��ͮ");
        list.add("�Ŵ��");
        list.add("������");


        System.out.println(list.stream().anyMatch(s->s.startsWith("��")));
        System.out.println("-------------");
        System.out.println(list.stream().allMatch(s->s.startsWith("��")));
        System.out.println("-------------");
        System.out.println(!list.stream().noneMatch(s->s.equals("������")));


    }
}
