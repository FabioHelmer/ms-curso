package com.fh.hrpayroll.services;

import com.fh.hrpayroll.entities.Payment;
import com.fh.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String hostWorker;

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long idWorker, int days) {

        Map<String, String> uriVariables =  new HashMap<>();
        uriVariables.put("id", String.valueOf(idWorker));

        String url = hostWorker + "/workers/{id}";
        Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
