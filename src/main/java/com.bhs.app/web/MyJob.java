package com.bhs.app.web;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2018/4/3.
 */

@ElasticSimpleJob(cron="0/5 * * * * ?",jobName="myJob1")
@Component
public class MyJob implements SimpleJob{

    @Override
    public void execute(ShardingContext content) {
        //do something
       /* System.out.println("JobName:"+content.getJobName());
        System.out.println("JobParameter:"+content.getJobParameter());
        System.out.println("ShardingItem:"+content.getShardingItem());
        System.out.println("ShardingParameter:"+content.getShardingParameter());
        System.out.println("ShardingTotalCount:"+content.getShardingTotalCount());
        System.out.println("TaskId:"+content.getTaskId());
        System.out.println("---------------------------------------");*/

    }
}
