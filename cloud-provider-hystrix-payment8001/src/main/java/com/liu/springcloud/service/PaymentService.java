package com.liu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
//        int a = 10/0;
        return "线程池："+ Thread.currentThread().getName()+" paymentInfo_OK,id:"+id +"\t哈哈";
    }

    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName()+" paymentInfo_TimeOut,id:"+id +"哭哭";
    }
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    //失败率达到多少后跳闸
    })
    public String paymentCircuiBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("***********id不能是负数！");
        }
        String seriaNo = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功！"+seriaNo;
    }
}
