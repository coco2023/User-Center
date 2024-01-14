package com.UmiUni.shop.userauthservice.extrenal.payment;

import com.UmiUni.shop.userauthservice.extrenal.model.AlipayRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.AlipayResponse;
import com.UmiUni.shop.userauthservice.extrenal.model.TransactionDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-ALIPAY-SERVICE/api/alipay")
public interface AliPayPaymentService {

    // test
    @PostMapping("/transaction")
    public String createTransaction(@RequestBody TransactionDetails details);

    // Alipay sandbox
    @PostMapping("/create-payment")
    public ResponseEntity<AlipayResponse> createPayment(@RequestBody AlipayRequest alipayRequest);

}
