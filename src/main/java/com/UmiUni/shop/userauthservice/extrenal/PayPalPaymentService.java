package com.UmiUni.shop.userauthservice.extrenal;

import com.UmiUni.shop.userauthservice.entity.SalesOrder;
import com.UmiUni.shop.userauthservice.extrenal.model.TransactionDetails;
import com.UmiUni.shop.userauthservice.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PAYMENT-PAYPAL-SERVICE")
public interface PayPalPaymentService {

    @PostMapping("/api/paypal/transaction")
    public String createTransaction(@RequestBody TransactionDetails details);

    // Endpoint to create a payment  localhost:9011/api/v1/payments/paypal/create
    @PostMapping("/api/v1/payments/paypal/create")
    public ResponseEntity<?> createPayment(@RequestBody SalesOrder salesOrder);

    // Endpoint to complete a payment
    @PostMapping("/api/v1/payments/paypal/complete")
    public ResponseEntity<PaymentResponse> completePayment(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, @RequestParam("SupplierId") String supplierId);

}
