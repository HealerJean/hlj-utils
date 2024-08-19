package com.hlj.util.z034_统计代码耗时.apache;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyujin
 * @date 2022/6/28  15:32.
 */
public class TestMain {


    @Test
    public void test() throws InterruptedException {

        //创建后立即start，常用
        StopWatch watch = StopWatch.createStarted();
        // StopWatch watch = new StopWatch();
        // watch.start();

        Thread.sleep(1000);
        System.out.println(StrUtil.format("统计从开始到现在运行时间：{} ms", watch.getTime()));
        // 统计从开始到现在运行时间：1006ms

        // 复位后, 重新计时
        watch.reset();
        watch.start();
        Thread.sleep(1000);
        System.out.println(StrUtil.format("重新开始后到当前运行时间是：{} ms", watch.getTime()));
        // 重新开始后到当前运行时间是：1006 ms

        // 暂停 与 恢复
        watch.suspend();
        System.out.println("暂停2秒钟");
        Thread.sleep(2000);

        // 上面suspend，这里要想重新统计，需要恢复一下
        watch.resume();
        System.out.println(StrUtil.format("恢复后执行的时间是：{} ms", watch.getTime()));
        // 恢复后执行的时间是：1001 ms

        Thread.sleep(1000);
        watch.stop();
        // 花费的时间》》：2010 ms
        System.out.println(StrUtil.format("花费的时间》》：{} ms", watch.getTime()));
        // 花费的时间》》：2004 ms

        // 转成 s
        System.out.println(StrUtil.format("花费的时间》》：{} s", watch.getTime(TimeUnit.SECONDS)));
        // 花费的时间》》：2 s
    }

}
