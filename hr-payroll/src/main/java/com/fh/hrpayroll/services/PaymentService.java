package com.fh.hrpayroll.services;

import com.fh.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long idWorker, int days) {
        return new Payment("Bob",200.0, days);
    }

}
