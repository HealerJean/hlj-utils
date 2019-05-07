package com.hlj.util.Z008HashCode;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

/**
 * @author HealerJean
 * @version 1.0v
 * @ClassName D01_HashCode
 * @date 2019/5/6  17:20.
 * @Description 测试Integer的 hashCode
 */
public class D01_HashCode {


    /**
     *    1、Integer 的 hashCode 就是它的value
     *
     *     public int hashCode() {
     *         return Integer.hashCode(value);
     *     }
     */
    @Test
    public void Integer_HashCode(){

        Integer one  = new Integer(20);
        System.out.println(one.hashCode()); //20

    }


    /**
     * ASCII http://tool.oschina.net/commons?type=4
     * 2、String 类的散列值就是依次遍历其每个字符成员，
     * 递归的将当前得到的hashCode乘以31然后加上下一个字符成员的ASCII值 （h = 31 * h + val[i];）
     *
     *   h 初始为 0
     *  '1'  49   h = 31 * 0  + 49 = 49
     *  '2'  50   h = 31 * 49 + 50 = 1569
     *  '3'  51   h = 31 * 1569 + 51 = 48690
     *
     *     public int hashCode() {
     *         int h = hash;
     *         if (h == 0 && value.length > 0) {
     *             char val[] = value;
     *
     *             for (int i = 0; i < value.length; i++) {
     *                 h = 31 * h + val[i];
     *             }
     *             hash = h;
     *         }
     *         return h;
     *     }
     */
    @Test
    public void String_HashCode(){
        String str1  ="123";
        System.out.println(str1.hashCode()); // 48690

    }


    /**
     * 为什么大部分 hashcode 方法使用 31
     * Object的 hashCode 方法实现也和 String 类型差不多。都是使用的 31 ，那么有没有想过：为什么要使用 31 呢？
     *
     * 之所以使用 31， 是因为他是一个奇素数。如果乘数是偶数，并且乘法溢出的话，信息就会丢失，因为与2相乘等价于移位运算
     * （低位补0）。使用素数的好处并不很明显，但是习惯上使用素数来计算散列结果。
     * 31 有个很好的性能，即用移位和减法来代替乘法，可以得到更好的性能： 31 * i == (i << 5） - i，
     * 现代的 VM 可以自动完成这种优化。这个公式可以很简单的推导出来。
     *
     */
    @Test
    public void Object_HashCode(){

    }

    public static Integer hashCode(String str, Integer multiplier) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = multiplier * hash + str.charAt(i);
        }

        return hash;
    }

    /**
     * 计算 hash code 冲突率，顺便分析一下 hash code 最大值和最小值，并输出
     * @param multiplier
     * @param hashs
     */
    public static void calculateConflictRate(Integer multiplier, List<Integer> hashs) {
        Comparator<Integer> cp = (x, y) -> x > y ? 1 : (x < y ? -1 : 0);
        int maxHash = hashs.stream().max(cp).get();
        int minHash = hashs.stream().min(cp).get();

        // 计算冲突数及冲突率
        int uniqueHashNum = (int) hashs.stream().distinct().count();
        int conflictNum = hashs.size() - uniqueHashNum;
        double conflictRate = (conflictNum * 1.0) / hashs.size();

        System.out.println(String.format("multiplier=%4d, minHash=%11d, maxHash=%10d, conflictNum=%6d, conflictRate=%.4f%%",
                multiplier, minHash, maxHash, conflictNum, conflictRate * 100));
    }

}
