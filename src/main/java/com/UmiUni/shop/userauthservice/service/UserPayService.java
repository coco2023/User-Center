package com.UmiUni.shop.userauthservice.service;

import com.UmiUni.shop.userauthservice.entity.User;
import com.UmiUni.shop.userauthservice.extrenal.AliPayPaymentService;
import com.UmiUni.shop.userauthservice.extrenal.PayPalPaymentService;
import com.UmiUni.shop.userauthservice.extrenal.StripePaymentService;
import com.UmiUni.shop.userauthservice.extrenal.model.ChargeRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.TransactionDetails;
import com.UmiUni.shop.userauthservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPayService {

    @Autowired
    private PayPalPaymentService payPalPaymentService;

    @Autowired
    private StripePaymentService stripePaymentService;

    @Autowired
    private AliPayPaymentService aliPayPaymentService;

    @Autowired
    private UserRepository userRepository;

    // user make payment via paypal
    public String initiatePayPalPayment(Long userId, TransactionDetails details) {
        // Validate the user ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        details.setUserId(userId);

        // Initiating payment
        return payPalPaymentService.createTransaction(details);
    }

    // user make payment via stripe
    public String initiateStripePayment(Long userId, ChargeRequest details) {
        // Validate the user ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        return stripePaymentService.createCharge(details);
    }


    // user make payment via alipay
    public String initiateAliPayPayment(Long userId, TransactionDetails details) {
        // Validate the user ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        details.setUserId(userId);

        return aliPayPaymentService.createTransaction(details);
    }

}
