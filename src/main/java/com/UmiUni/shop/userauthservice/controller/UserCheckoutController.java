package com.UmiUni.shop.userauthservice.controller;

import com.UmiUni.shop.userauthservice.dto.SalesOrderDTO;
import com.UmiUni.shop.userauthservice.entity.SalesOrder;
import com.UmiUni.shop.userauthservice.extrenal.model.AlipayRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.AlipayResponse;
import com.UmiUni.shop.userauthservice.extrenal.model.StripePaymentRequest;
import com.UmiUni.shop.userauthservice.model.OrderCreationRequest;
import com.UmiUni.shop.userauthservice.model.PaymentResponse;
import com.UmiUni.shop.userauthservice.service.UserCheckoutService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/checkout")
@CrossOrigin(origins = "http://localhost:3000")
public class UserCheckoutController {

    @Autowired
    private UserCheckoutService userCheckoutService;

    /**
     * PayPal
     */
    // localhost:9024/api/users/checkout/create-order
    @PostMapping("/create-order")
    public ResponseEntity<?> createOrderAndCheckout(@RequestBody SalesOrderDTO orderRequest) {
        try {
            Object response = userCheckoutService.processOrder(orderRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

//    // localhost:9024/api/users/checkout/complete-order
//    @PostMapping("/complete-order")
//    public ResponseEntity<?> completeOrderAndCheckout(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, @RequestParam("SupplierId") String supplierId) {
//        PaymentResponse paymentResponse = userCheckoutService.completeOrder(paymentId, payerId, supplierId);
//        return ResponseEntity.ok(paymentResponse);
//    }

    /**
     * Stripe
     * http://localhost:9024/api/users/checkout/stripe/charge
     */
    @PostMapping("/stripe/charge")
    public ResponseEntity<?> payByStripe(@RequestBody StripePaymentRequest request) {
        try {
            Object response = userCheckoutService.processOrderByStripe(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * AliPay
     * http://localhost:9024/api/users/checkout/alipay/pay
     */
    @PostMapping("/alipay/pay")
    public ResponseEntity<?> payByAlipay(@RequestBody AlipayRequest alipayRequest) {
        try {
            AlipayResponse alipayResponse = userCheckoutService.processOrderByAlipay(alipayRequest);
            return ResponseEntity.ok(alipayResponse);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
