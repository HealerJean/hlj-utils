package com.hlj.util.z034_统计代码耗时.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author zhangyujin
 * @date 2022/6/28  15:04.
 */
@Slf4j
public class TestMain {

    @Test
    public void test() throws InterruptedException {

        StopWatch stopWatch = new StopWatch();

        // 任务一模拟休眠3秒钟
        stopWatch.start("TaskOneName");
        Thread.sleep(1000 * 3);
        log.info("当前任务名称：{}", stopWatch.currentTaskName());
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }

        // 任务一模拟休眠10秒钟
        stopWatch.start("TaskTwoName");
        Thread.sleep(1000 * 10);
        log.info("当前任务名称：{}", stopWatch.currentTaskName());
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }

        // 打印出耗时
        log.info("stopWatch.prettyPrint():{}", stopWatch.prettyPrint());
        log.info("stopWatch.shortSummary():{}", stopWatch.shortSummary());
        // stop后它的值为null
        log.info("stopWatch.currentTaskName():{}", stopWatch.currentTaskName());

        // 最后一个任务的相关信息
        log.info("stopWatch.getLastTaskName():{}", stopWatch.getLastTaskName());
        log.info("stopWatch.getLastTaskInfo():{}", stopWatch.getLastTaskInfo());

        // 任务总的耗时  如果你想获取到每个任务详情（包括它的任务名、耗时等等）可使用
        log.info("所有任务总耗时：{}", stopWatch.getTotalTimeMillis());

        log.info("任务总数：{}", stopWatch.getTaskCount());
        log.info("所有任务详情：{}", stopWatch.getTaskInfo());
    }
}
