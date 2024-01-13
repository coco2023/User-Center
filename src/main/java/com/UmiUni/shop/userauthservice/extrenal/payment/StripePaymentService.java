package com.UmiUni.shop.userauthservice.extrenal.payment;

import com.UmiUni.shop.userauthservice.extrenal.model.ChargeRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.StripePaymentRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.StripePaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-STRIPE-SERVICE")
public interface StripePaymentService {

    /**
     * Stripe Payment
     * http://localhost:9012/api/v1/payments/stripe/charge
     */
    @PostMapping("/api/v1/payments/stripe/charge")
    public ResponseEntity<StripePaymentResponse> createCharge(@RequestBody StripePaymentRequest request);

    // test
    @PostMapping("/api/stripe/charge")
    public String createChargeTest(@RequestBody ChargeRequest chargeRequest);

}
