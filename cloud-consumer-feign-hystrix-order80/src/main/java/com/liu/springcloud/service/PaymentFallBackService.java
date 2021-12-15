package com.liu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK 服务降级了";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut 服务降级了";
    }

    @Override
    public String paymentCircuiBreaker(Integer id) {
        return "paymentCircuiBreaker服务降级了 id不能为负数！"+id;
    }
}
