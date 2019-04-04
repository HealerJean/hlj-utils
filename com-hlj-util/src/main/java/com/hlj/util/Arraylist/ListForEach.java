package com.hlj.util.Arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author HealerJean
 * @Date 2018/5/8  ����9:53.
 */
public class ListForEach {

    /**
         List������һ����Ա����modCount���������List�����޸ĵĴ�����ÿ��List�����޸�һ�Σ�modCount�����1.

     ����Itr������һ����Ա����expectedModCount������ֵΪ����Itr�����ʱ��List��modCountֵ��
       �ô˱����������ڵ���������List�����Ƿ��޸��ˣ�������޸������׳�java.Z007二维码.ConcurrentModificationException�쳣��

       ��ÿ�ε���Itr�����next()����remove������ʱ�򶼻����checkForComodification()��������һ�μ��飬
       checkForComodification()���������Ĺ������ǱȽ�expectedModCount ��modCount��ֵ�Ƿ���ȣ��������ȣ�
      ����Ϊ���������������ڶԵ�ǰ��List���в������Ǹ��ͻ��׳�ConcurrentModificationException�쳣��

      ��list��������ġ�c"ɾ���ˣ�ͬʱlist�����modCountֵ��1������Itr�����expectedModCountû�б䣬���ǿ϶��ǲ�����ˡ�����һ��ִ��next()������ʱ�������checkForComodification()��������ʱ����׳��쳣�ˡ�
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){       //�ս���cursorΪ0 
            String str = (String) iterator.next(); //��һ��next֮���α�Ϊ1��ָ�������һ����������list����size�ж��Ƿ���δ�����Ķ���
          if(str.equals("c")){ //a b checkForComodification
                list.remove(str);
          }
//            if(str.equals("d")){ // a b c
//                //����ͨ��Itr�Ķ����cursor��List�����sizeֵ���ж��Ƿ���δ�����Ķ���
//                // �������ꡰd"��ʱ��cursor=4��ɾ����d"��ʱ��List�����size�ͻ��1��size����Ϊ5��������Ϊ4��
//                // ��ʱ��cursor��size����ȵģ�hasNext()�������ص���false������Ϊ���������ˣ�
//                // ����ɾ���Ժ�û�н�ȥִ��next()�����ˣ���û���׳��쳣�ˣ���Ȼ"e"Ҳû���������
//                list.remove(str);   //
//            }
            else{
                System.out.println(str);
            }
        }

    }


    @Test
    public void remove(){
        List<String> list = new ArrayList();
        list.add("aaaaaa");
        list.add("bbbbbb");
        list.add("cccccc");
        list.add("dddddd");
        list.add("eeeeee");

        Iterator it = list.iterator();
        //it.remove(); //ɾ��������һ��Ԫ�� IllegalStateException
        int i = 0;
        String s = null;
        while(it.hasNext()){
            if(i==2){
//              list.remove(it.next()); �����list.remove(it.next());�ᱨ�쳣checkForComodification
                it.remove();//remove����b remove֮��cursor���1,��Ϊcursorָ�������һ��������ɾ��֮����һ�������ͻ��1��Ȼ��list�������1
                            //���ʱ�� ��cԪ�ص� it��cursor��2 ����� 1 cԪ�ض�����b��cursor�ͱ����cursor=1
            }
            System.out.println("��"+i+"��Ԫ��"+it.next());
            i++ ;
        }
        System.out.println("----------------");
        Iterator it2 = list.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

    }
//
//    ��0��Ԫ��aaaaaa
//    ��1��Ԫ��bbbbbb
//    ��2��Ԫ��cccccc
//    ��3��Ԫ��dddddd
//    ��4��Ԫ��eeeeee
//----------------
//    aaaaaa
//    cccccc
//    dddddd
//    eeeeee


}
