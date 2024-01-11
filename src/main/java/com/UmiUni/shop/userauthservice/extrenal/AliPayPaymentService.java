package com.UmiUni.shop.userauthservice.extrenal;

import com.UmiUni.shop.userauthservice.extrenal.model.TransactionDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-ALIPAY-SERVICE/api/alipay")
public interface AliPayPaymentService {

    @PostMapping("/transaction")
    public String createTransaction(@RequestBody TransactionDetails details);
}
