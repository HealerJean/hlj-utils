package com.hlj.util;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class ComHljUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComHljUtilApplication.class, args);
    }


    @Test
    public void test() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(7);

        long daysDiff = ChronoUnit.DAYS.between(startTime, endTime);
		System.out.println("相差天数：" + daysDiff);

    }
}

