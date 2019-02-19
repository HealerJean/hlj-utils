package com.hlj.util.Z002Stack;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 作者 ：HealerJean
 * 日期 ：2019/2/18  下午10:48.
 *
 *  执行push时(即，将元素推入栈中)，是通过将元素追加的数组的末尾中。
 *  执行peek时(即，取出栈顶元素，不执行删除)，是返回数组末尾的元素。
 *  执行pop时(即，取出栈顶元素，并将该元素从栈中删除)，是取出数组末尾的元素，然后将该元素从数组中删除。
 *
 */
public class D01Stack {

    @Test
    public  void test() {
        Stack<String> stack = new Stack();
        // 将1,2,3,4,5添加到栈中
        for(int i=1; i<6; i++) {
            stack.push(String.valueOf(i));
        }

        // 遍历并打印出该栈
        iteratorThroughRandomAccess(stack) ; //1 2 3 4 5
        System.out.println();

        // 查找“2”在栈中的位置，并输出 ,从顶部向下寻找
        int pos = stack.search("2");
        System.out.println("the postion of 2 is:"+pos); //4

        // pup栈顶元素之后，遍历栈
        stack.pop();
        iteratorThroughRandomAccess(stack) ; //1 2 3 4

        // peek栈顶元素之后，遍历栈
        String val = stack.peek();
        System.out.println("peek:"+val); //1 2 3 4
        iteratorThroughRandomAccess(stack) ;

    }

    /**
     * 通过快速访问遍历Stack
     */
    public  void iteratorThroughRandomAccess(List list) {
        list.forEach(s->{
            System.out.print(s+"_");
        });
    }


    /**
     *
     * 1_2_3_4_5_
     * the postion of 2 is:4
     * 1_2_3_4_peek:4
     * 1_2_3_4_
     *
     */


}
