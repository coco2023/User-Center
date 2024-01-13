package com.UmiUni.shop.userauthservice.extrenal.payment;

import com.UmiUni.shop.userauthservice.extrenal.model.ChargeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-STRIPE-SERVICE/api/stripe")
public interface StripePaymentService {

    @PostMapping("/charge")
    public String createCharge(@RequestBody ChargeRequest chargeRequest);

}
