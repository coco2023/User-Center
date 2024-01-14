package com.UmiUni.shop.userauthservice.service;

import com.UmiUni.shop.userauthservice.dto.SalesOrderDTO;
import com.UmiUni.shop.userauthservice.extrenal.model.AlipayRequest;
import com.UmiUni.shop.userauthservice.extrenal.model.AlipayResponse;
import com.UmiUni.shop.userauthservice.extrenal.model.StripePaymentRequest;

public interface UserCheckoutService {

    Object processOrder(SalesOrderDTO orderRequest) throws Exception;

    Object processOrderByStripe(StripePaymentRequest request);

    AlipayResponse processOrderByAlipay(AlipayRequest alipayRequest);

//    PaymentResponse completeOrder(String paymentId, String payerId, String supplierId);
}
