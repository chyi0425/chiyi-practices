package com.chiyi.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author chiyi
 * @date 2019/5/28.
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("do something...");
    }

    public static void main(String[] args) throws SchedulerException {
        // create job
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();

        // create trigger ,executed every three second
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()
        ).build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // put job into scheduler
        scheduler.scheduleJob(jobDetail, trigger);
        // start scheduler
        scheduler.start();

    }
}
