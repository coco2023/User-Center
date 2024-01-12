package com.UmiUni.shop.userauthservice.service.impl;

import com.UmiUni.shop.userauthservice.dto.SalesOrderDTO;
import com.UmiUni.shop.userauthservice.dto.SalesOrderDetailDTO;
import com.UmiUni.shop.userauthservice.entity.SalesOrder;
import com.UmiUni.shop.userauthservice.entity.SalesOrderDetail;
import com.UmiUni.shop.userauthservice.extrenal.PayPalPaymentService;
import com.UmiUni.shop.userauthservice.extrenal.salesOrder.SalesOrderDetailService;
import com.UmiUni.shop.userauthservice.extrenal.salesOrder.SalesOrderService;
import com.UmiUni.shop.userauthservice.model.OrderCreationRequest;
import com.UmiUni.shop.userauthservice.model.PaymentResponse;
import com.UmiUni.shop.userauthservice.service.UserCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCheckoutServiceImpl implements UserCheckoutService {

    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private SalesOrderDetailService salesOrderDetailService;

    @Autowired
    PayPalPaymentService payPalPaymentService;

    @Override
    public SalesOrder processOrder(SalesOrderDTO salesOrderDTO) throws Exception {

        // Step 1: Create Sales Order
        SalesOrder salesOrder = convertToSalesOrder(salesOrderDTO);
        ResponseEntity<SalesOrder> orderResponse = salesOrderService.createSalesOrder(salesOrder);

        if (!orderResponse.getStatusCode().is2xxSuccessful() || orderResponse.getBody() == null) {
            throw new Exception("Failed to create sales order");
        }

        SalesOrder createdOrder = orderResponse.getBody();

        // Step 2: Add Sales Order Details
        for (SalesOrderDetailDTO detail : salesOrderDTO.getSalesOrderDetail()) {
            SalesOrderDetail salesOrderDetail = convertToSalesOrderDetail(detail, createdOrder.getSalesOrderId());
            salesOrderDetailService.createSalesOrderDetail(salesOrderDetail);
        }

        // Step 3: Process Payment
        ResponseEntity<?> paymentResponse = payPalPaymentService.createPayment(createdOrder);

        if (!paymentResponse.getStatusCode().is2xxSuccessful()) {
            throw new Exception("Payment processing failed");
        }

        // Update SalesOrder with payment status

        return createdOrder;

    }

    @Override
    public PaymentResponse completeOrder(String paymentId, String payerId, String supplierId) {
        return payPalPaymentService.completePayment(paymentId, payerId, supplierId).getBody();
    }

    private SalesOrder convertToSalesOrder(SalesOrderDTO request) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setSalesOrderId(request.getSalesOrderId());
        salesOrder.setSalesOrderSn(request.getSalesOrderSn());
        salesOrder.setCustomerId(request.getCustomerId());
        salesOrder.setSupplierId(request.getSupplierId());
        salesOrder.setCustomerName(request.getCustomerName());
        salesOrder.setCustomerEmail(request.getCustomerEmail());
        salesOrder.setOrderDate(request.getOrderDate());
        salesOrder.setTotalAmount(request.getTotalAmount());
        salesOrder.setShippingAddress(request.getShippingAddress());
        salesOrder.setBillingAddress(request.getBillingAddress());
        salesOrder.setOrderStatus(request.getOrderStatus());
        salesOrder.setPaymentMethod(request.getPaymentMethod());
        salesOrder.setPaymentProcessed(request.getPaymentProcessed());
        salesOrder.setLastUpdated(request.getLastUpdated());
        salesOrder.setExpirationDate(request.getExpirationDate());
        return salesOrder;
    }

    private SalesOrderDetail convertToSalesOrderDetail(SalesOrderDetailDTO detail, Long salesOrderId) {
        SalesOrderDetail salesOrderDetail = new SalesOrderDetail();
        salesOrderDetail.setSalesOrderDetailId(detail.getSalesOrderDetailId());
        salesOrderDetail.setSalesOrderSn(detail.getSalesOrderSn());
        salesOrderDetail.setSkuCode(detail.getSkuCode());
        salesOrderDetail.setSupplierId(detail.getSupplierId());
        salesOrderDetail.setQuantity(detail.getQuantity());
        salesOrderDetail.setUnitPrice(detail.getUnitPrice());
        salesOrderDetail.setDiscount(detail.getDiscount());
        salesOrderDetail.setLineTotal(detail.getLineTotal());
        // associate the detail with the SalesOrder's ID
        return salesOrderDetail;
    }

}
