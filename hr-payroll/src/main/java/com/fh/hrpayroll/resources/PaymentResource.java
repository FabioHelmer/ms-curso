package com.fh.hrpayroll.resources;

import com.fh.hrpayroll.entities.Payment;
import com.fh.hrpayroll.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    private final PaymentService service;

    public PaymentResource(PaymentService service) {
        this.service = service;
    }

    @GetMapping(value = {"/{idWorker}/days/{days}"})
    public ResponseEntity<Payment> getPayment(@PathVariable Long idWorker, @PathVariable Integer days) {
        Payment payment = service.getPayment(idWorker, days);
        return ResponseEntity.ok(payment);
    }

}
