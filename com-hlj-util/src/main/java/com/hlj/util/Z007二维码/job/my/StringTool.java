package com.hlj.util.Z007二维码.job.my;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� ��HealerJean
 * ���� ��2018/12/27  ����2:31.
 * ��������
 */
public class StringTool {


    /**
     * ��ԭʼ�ַ����ָ��ָ�����ȵ��ַ����б�
     * @param inputString  ԭʼ�ַ���
     * @param length   ָ������
     * @return
     */
    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }


    /**
     * ��ԭʼ�ַ����ָ��ָ�����ȵ��ַ����б�
     * @param inputString ԭʼ�ַ���
     * @param length ָ������
     * @param size  ָ���б��С
     * @return
     */
    public static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }
    /**
     * �ָ��ַ����������ʼλ�ô����ַ������ȣ����ؿ�
     * @param str  ԭʼ�ַ���
     * @param f ��ʼλ��
     * @param t  ����λ��
     * @return
     */
    public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }


}
