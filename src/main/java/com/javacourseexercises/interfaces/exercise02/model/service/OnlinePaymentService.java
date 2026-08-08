package com.javacourseexercises.interfaces.exercise02.model.service;

public interface OnlinePaymentService {

    Double paymentFee(double amount);
    Double interest(double amount, int months);
}
