package com.hlj.util.Z022_String;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StringTest {




    /**
     * 1、判断是否为空
     * isEmpty： 有内容有就为true
     * isBlank ：判断经历过trim后是否为空，判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成，
     */
    @Test
    public void empty() {
        System.out.println(StringUtils.isEmpty("aaa")); //false
        System.out.println(StringUtils.isEmpty(null)); //true
        System.out.println(StringUtils.isEmpty("")); //true
        System.out.println(StringUtils.isEmpty("\n")); //false
        System.out.println(StringUtils.isEmpty(" "));//false

        System.out.println("-------------------------");
        System.out.println(StringUtils.isBlank("aaa")); //false
        System.out.println(StringUtils.isBlank(null)); //true
        System.out.println(StringUtils.isBlank("")); //true
        System.out.println(StringUtils.isBlank("\n")); //true
        System.out.println(StringUtils.isBlank(" "));//true
    }


    /**
     * 2、% 变量替换
     * %s ：字符串类型，也可以放入其他类型，比如，整数，小数等等
     * %c ：字符类型  'm'
     * %b ：布尔类型 true
     * %d ：整数类型（十进制）
     * %.4f%% ： 小数  55.1510%
     * %05d ： 补齐位数，0 代表前面补充0,5 代表长度为5, d 代表参数为正数型，（不足的打印0，超出的正常显示原始数据）
     */
    @Test
    public void strisngFormat() {

        String s = "____%s____";
        System.out.println(String.format(s, "mingrisoft")); //____mingrisoft____

        String c = "____%c____";
        System.out.println(String.format(c, 'c')); //____c____

        String b = "____%b____";
        System.out.println(String.format(b, true)); //____true____

        String d = "____%d____";
        System.out.println(String.format(d, 125));//____125____

        String str = "____%s____" + "____%c____" + "____%b____" + "____%d____";
        System.out.println(String.format(str, "mingrisoft", 'c', true, 123));

        System.out.println(String.format("%05d", 24));  //00024
        System.out.println(String.format("%05d", 123456)); //123456
    }


    /**
     * 3、MessageFormat.format，占位符替换
     * 注意：格式化字符串时，两个单引号才表示一个单引号，单个单引号会被省略
     */
    @Test
    public void messageFormat() {
        //1、占位
        String msg = "{0},{1},{2},{3},{4},{5},{6},{7},{8}";
        Object[] array = new Object[]{"A", "B", "C", "D", "E", "F", 1525.12, 10, BigDecimal.ZERO};
        System.out.println(MessageFormat.format(msg, array));
        // 输出：A,B,C,D,E,F,1,525.12,10,0

        System.out.println(MessageFormat.format("oh, {0} is 'a' ''pig''", "ZhangSan"));
        //输出： oh, ZhangSan is a 'pig'
    }

    /**
     * 4、把原始字符串分割成指定长度的字符串列表
     */
    @Test
    public void testLengthSplit() {
        System.out.println(getStrList("12", 3));
    }

    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString 原始字符串
     * @param length      指定长度
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
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString 原始字符串
     * @param length      指定长度
     * @param size        指定列表大小
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
     * 分割字符串，如果开始位置大于字符串长度，返回空
     *
     * @param str 原始字符串
     * @param f   开始位置
     * @param t   结束位置
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


    /**
     * 5、比较速度
     * String.toString() 》  String.valueOf() >  i + ""
     */
    @Test
    public void testSpeed() {

        int loopTime = 50000;
        Integer i = 0;

        long startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = String.valueOf(i);
        }

        System.out.println("String.valueOf()：" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i.toString();
        }

        System.out.println("Integer.toString()：" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i + "";
        }
        System.out.println("i + \"\"：" + (System.currentTimeMillis() - startTime) + "ms");


        // 结果
        // Integer.toString()：6ms
        // String.valueOf()：21ms
        // i + ""：38ms
    }


    /**
     * 6、Z022_String 和byte数组的转化
     */
    @Test
    public void testbyteArray() throws UnsupportedEncodingException {
        String str = "HealerJean";
        byte[] byteArray;
        byteArray = str.getBytes("utf-8");
        String strByte = new String(byteArray, "UTF-8");
        System.out.println("byte数组：" + byteArray + "\n" + "Z022_String:" + strByte);
    }


    /**
     * 7、String 和 StringBuffer之间的转化
     */
    @Test
    public void strToBuffer() {
        //String -> StringBuffer 1、构造方法  2、通过append方法
        //创建一个String对象
        String str = "Hi Java!";
        System.out.println(str);

        //方式一：构造方法
        StringBuffer buffer = new StringBuffer(str);
        System.out.println(buffer);

        //方式二：通过append方法
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append(str);
        System.out.println(buffer2);


        //StringBuffer -> String
        //创建一个StringBuffer对象 1、构造方法 2、toString方法
        StringBuffer buffer3 = new StringBuffer();
        buffer3.append("Happy birthday Java!");
        System.out.println(buffer3);

        //方式一：通过构造方法
        String str2 = new String(buffer3);
        System.out.println(str2);

        //方式二：通过toString方法
        String str3 = buffer3.toString();
        System.out.println(str3);
    }


    /**
     * 8、测试string 可不可以 +
     */
    @Test
    public void teststringadd() {

        //未提前定义好对象
        //String m = m +"abc"; //错误的

        //如果提前定义对象，是可以的
        String a = "123";
        String b = "";
        b += "abc";
        b = b + "a";
    }


    /**
     * 9、String ...不定参数
     */
    @Test
    public void testPrintStringMain() {
        printString();
        System.out.println("==========");
        printString(new String[]{"我", "和", "你"});
    }

    public void printString(String... str) {
        if (str.length == 0) {
            System.out.println("没有传参数。");
        }
        for (int i = 0; i < str.length; i++) {
            System.out.printf(str[i]);
        }
    }
    // 没有传参数。
    // ==========
    // 我和你


    /**
     * 10、数组的定义
     */
    @Test
    public void array() {
        //1、
        int[] a = new int[3]; //定义一个数组
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        //	a[4] = 5; //超出限制 报错

        //2、动态初始化
        int b[];
        //  b[1] = 2;  没有给定大小，报错
        b = new int[5];

        //3、 静态初始化
        //  int c[3] = {1,4,2,3}; 不能给定值
        int c[] = {1, 4, 2, 3};

        //4、new 并直接静态赋值，不可写入大小
        //  int d[] = new int[5]{1,2,3}; 错误
        int d[] = new int[]{1, 2, 3};
    }


    /***
     * 11、substring 截取的是字节还是字符
     * String类的length()方法是以unicode代码单元，换言之就是char的个数为来统计的。
     * 所以使用subString等截取出来的子串都不会出现半个汉字的情况，
     * 因为java一个char类型可以存放一个汉字（2个字节）。而如果以字节byte来截取字符串，就会出现半个汉字的情况。
     *
     *
     * 测试：按字节数截取字符串, 不能截出半个汉字, 如果是半个汉字则舍去!
     *  思路：汉字的unicode编码都是负数，如果这些负数字节在截取的字节数组中成对出现，说明不会截取到半个汉字。
     *        如果不是成对出现，则会截取到半个汉字，需要将最后一个字节舍去。
     */
    @Test
    public void testSubStringByteOr() {
        String source = "我是一abcd个好人cccc";
        int byteCount = 8; //表示截取多少个
        byte[] byteArr = source.getBytes();
        System.out.println("字节大小为" + byteArr.length);
        int count = 0;
        // 统计要截取的那部分字节中负数的个数
        for (int i = 0; i < byteCount; i++) {
            if (byteArr[i] < 0) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("负数的个数为" + count);

        // 负数成对出现 则不会出现半个汉字
        if (count % 2 == 0)
            System.out.println(new String(byteArr, 0, byteCount));
            // 负数个数不是偶数，则有半个汉字
        else
            System.out.println(new String(byteArr, 0, byteCount - 1));
    }


    /**
     * 12、测试null+字符串的值
     */
    @Test
    public void testnull() {
        System.out.println( null + "abc"); // nullabc
        System.out.println( "abc" + (2 + 1)); //abc3
        System.out.println("abc" + 2 + 1); //abc21
    }



    /**
     * 13、测试字符串是否改变
     */
    @Test
    public void testChange(){
        String str = "a";
        StringTest stringTest = new StringTest();
        int i = 1;
        int a[] = {1, 2, 3};
        String abc[] = {"a", "b", "c"};
        stringTest.change(str, i, a, abc);
        System.out.println(str); //a 不会改变
        System.out.println(i);//1 不会改变
        System.out.println(a[2]); //56
        System.out.println(abc[2]); //ef
    }

    void change(String str, int i, int[] a, String abc[]) {
        i = 123;
        str = "abc";
        a[2] = 56;
        abc[2] = "ef";
    }



    /**
     * 14、测试 split分割
     */
    @Test
    public void Testsplit() {
        //
        String a = "abcdef";
        String[] aStrings = a.split("");
        System.out.println("0输出" + aStrings[0]); //输出a
        System.out.println("5输出" + aStrings[5]); //输出f
        System.out.println(aStrings.length);  //6

        for (String b : aStrings) {
            System.out.println(b); //a b c d e f
        }
    }

    /**
     * 15、StringUtils.join
     */
    @Test
    public void test(){
        String[] strArray  = new String[]{"a", "b", "c"};
        String join = StringUtils.join(strArray);
        System.out.println(join);//abc

        join = StringUtils.join(strArray, "-");
        System.out.println(join);//a-b-c

        List<String> strList = Lists.newArrayList("a", "b", "c");
        join = StringUtils.join(strList, "-");
        System.out.println(join);//a-b-c
    }

    /**
     * 16、计算字符串字节数
     */
    @Test
    public void test_16() throws UnsupportedEncodingException {
        String charsetName = "UTF-8";
        int mSize = 1024 * 1024; //1M
        int kSize = 1024; //1kb
        //制作1024个字节
        StringBuilder sb = new StringBuilder();
        while (sb.toString().getBytes(charsetName).length < kSize){
            sb.append("1");
        }
        String fs = sb.toString();
        System.out.println(fs.length());
        System.out.println(fs.getBytes().length);
    }


    /**
     * 17、concat
     */
    @Test
    public void test_17(){
        String str = "ABC".concat("_").concat("Message");
        System.out.println(str);
    }



}
