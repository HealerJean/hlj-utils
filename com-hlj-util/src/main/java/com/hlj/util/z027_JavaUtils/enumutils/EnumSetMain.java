package com.hlj.util.z027_JavaUtils.enumutils;

import com.google.common.collect.ImmutableList;
import com.hlj.util.z027_JavaUtils.enumutils.enums.DayEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangyujin
 * @date 2021/2/23  6:33 下午.
 * @description
    // 初始集合包括指定枚举类型的所有枚举值
    <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType)
    // 初始集合包括枚举值中指定范围的元素
    <E extends Enum<E>> EnumSet<E> range(E from, E to)
    // 初始集合包括指定集合的补集
    <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s)
    // 初始集合包括参数中的所有元素
    <E extends Enum<E>> EnumSet<E> of(E e)
    <E extends Enum<E>> EnumSet<E> of(E e1, E e2)
    <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3)
    <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4)
    <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4, E e5)
    <E extends Enum<E>> EnumSet<E> of(E first, E... rest)
    // 初始集合包括参数容器中的所有元素
    <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s)
    <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c)
 */
@Slf4j
public class EnumSetMain {


    /**
     * 1、noneOf返回的Set为空
     * EnumSet<E> noneOf(Class<E> elementType)
     */
    @Test
    public void noneOf(){
        //
        Set<DayEnum> days = EnumSet.noneOf(DayEnum.class);
        log.info("Set<DayEnum> = {} ", days);
        days.add(DayEnum.SATURDAY);
        days.add(DayEnum.SUNDAY);
        log.info("Set<DayEnum> = {} ", days);

        // []
        // [SATURDAY, SUNDAY]
    }


    /**
     * 2、 EnumSet.of
     */
    @Test
    public void of(){
        Set<DayEnum> days = EnumSet.of(DayEnum.MONDAY, DayEnum.THURSDAY);
        log.info("Set<DayEnum> = {} ", days);
        // Set<DayEnum> = [MONDAY, THURSDAY]
    }


    /**
     * 3、allOf
     */
    @Test
    public void allOf(){
        Set<DayEnum> days = EnumSet.allOf(DayEnum.class);
        log.info("Set<DayEnum> = {} ", days);
        // Set<DayEnum> = [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
    }


    /**
     * 4、 EnumSet.range ：
     */
    @Test
    public void range(){
        Set<DayEnum> range = EnumSet.range(DayEnum.TUESDAY, DayEnum.FRIDAY);
        log.info("Set<DayEnum> = {} ", range);
        // Set<DayEnum> = [TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
    }


    /**
     * 5、complementOf ：从其补充初始化枚举设置此枚举set。
     *
     */
    @Test
    public void complementOf(){
        EnumSet<DayEnum> days = EnumSet.of(DayEnum.MONDAY, DayEnum.THURSDAY);
        log.info("Set<DayEnum> = {} ", days);
        // Set<DayEnum> = [MONDAY, THURSDAY]
        EnumSet<DayEnum> days2 = EnumSet.complementOf(days);
        log.info("Set<DayEnum> = {} ", days2);
        // Set<DayEnum> = [TUESDAY, WEDNESDAY, FRIDAY, SATURDAY, SUNDAY]
    }


    /**
     * 6、copyOf：从集合类中复制数据
     */
    @Test
    public void copyOf(){
        List<DayEnum> dayList = ImmutableList.of(DayEnum.MONDAY, DayEnum.THURSDAY, DayEnum.THURSDAY);
        EnumSet<DayEnum> daySet = EnumSet.copyOf(dayList);
        // Set<DayEnum> = [MONDAY, THURSDAY]
        log.info("Set<DayEnum> = {} ", dayList);
        // Set<DayEnum> = [MONDAY, THURSDAY, THURSDAY]
    }



}
