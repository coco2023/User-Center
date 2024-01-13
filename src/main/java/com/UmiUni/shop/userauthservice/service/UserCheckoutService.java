package com.UmiUni.shop.userauthservice.service;

import com.UmiUni.shop.userauthservice.dto.SalesOrderDTO;
import com.UmiUni.shop.userauthservice.entity.SalesOrder;
import com.UmiUni.shop.userauthservice.model.OrderCreationRequest;
import com.UmiUni.shop.userauthservice.model.PaymentResponse;

public interface UserCheckoutService {

    Object processOrder(SalesOrderDTO orderRequest) throws Exception;

//    PaymentResponse completeOrder(String paymentId, String payerId, String supplierId);
}
