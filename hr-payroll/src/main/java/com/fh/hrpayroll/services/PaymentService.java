package com.fh.hrpayroll.services;

import com.fh.hrpayroll.entities.Payment;
import com.fh.hrpayroll.entities.Worker;
import com.fh.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long idWorker, int days) {
        Worker worker = workerFeignClient.findById(idWorker).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
