package com.javacourseexercises.Interface2.model.service;

public interface OnlinePaymentService {

    Double paymentFee(double amount);
    Double interest(double amount, int months);
}
