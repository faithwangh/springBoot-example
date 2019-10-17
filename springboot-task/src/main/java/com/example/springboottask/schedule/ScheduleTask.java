package com.example.springboottask.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduleTask {

    /**
     * 每5秒执行一次
     */
    @Async("asyncThreadPool")
    @Scheduled(fixedRate = 5000)
    public void task1() {
        log.info("task1");
    }


    /**
     * 每天上午10点，下午2点，4点
     */
    @Async("asyncThreadPool")
//    @Scheduled(cron = "0 0 10,15,16 * * ?")
    @Scheduled(fixedRate = 2000)
    public void task2() {
        log.info("task2");
    }

}
