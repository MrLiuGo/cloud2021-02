package com.liu.springcloud.controller;

import com.liu.springcloud.entities.CommonResult;
import com.liu.springcloud.entities.Payment;
import com.liu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serviceport;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入数据库成功！serviceport:"+serviceport,payment);
        }else{
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功！serviceProt:"+serviceport,payment);

        }else {
            return new CommonResult(444,"查询失败！",null);

        }


    }


}
