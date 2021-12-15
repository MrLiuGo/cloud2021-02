package com.liu.springcloud.service;

import com.liu.springcloud.dao.PaymentDao;
import com.liu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        System.out.println(id);
        System.out.println(id);
        return paymentDao.getPaymentById(id);
    }
}
