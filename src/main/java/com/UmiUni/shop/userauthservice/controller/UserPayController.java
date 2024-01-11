package com.UmiUni.shop.userauthservice.controller;

import com.UmiUni.shop.userauthservice.extrenal.model.ChargeRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.TransactionDetails;
import com.UmiUni.shop.userauthservice.service.UserPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserPayController {

    @Autowired
    private UserPayService userPayService;

    @PostMapping("/{userId}/pay/paypal")
    public ResponseEntity<String> makePayPalPayment(@PathVariable Long userId, @RequestBody TransactionDetails details) {
        String paymentStatus = userPayService.initiatePayPalPayment(userId, details);
        return new ResponseEntity<>(paymentStatus, HttpStatus.OK);
    }

    @PostMapping("/{userId}/pay/stripe")
    public ResponseEntity<String> makeStripePayment(@PathVariable Long userId, @RequestBody ChargeRequest details) {
        String paymentStatus = userPayService.initiateStripePayment(userId, details);
        return new ResponseEntity<>(paymentStatus, HttpStatus.OK);
    }

    @PostMapping("/{userId}/pay/alipay")
    public ResponseEntity<String> makeAliPayPayment(@PathVariable Long userId, @RequestBody TransactionDetails details) {
        String paymentStatus = userPayService.initiateAliPayPayment(userId, details);
        return new ResponseEntity<>(paymentStatus, HttpStatus.OK);
    }

}
