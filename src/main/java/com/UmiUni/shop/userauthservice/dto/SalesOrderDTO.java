package com.UmiUni.shop.userauthservice.dto;

import com.UmiUni.shop.userauthservice.constant.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class SalesOrderDTO {

    private Long salesOrderId;

    private String salesOrderSn;  // reco

    private Long customerId;  // Assuming CustomerID is a unique identifier but not a foreign key

    private Long supplierId;

    private String customerName;

    private String customerEmail;

    private LocalDateTime orderDate;  // reco

    private BigDecimal totalAmount;  // reco

    private String shippingAddress;

    private String billingAddress;

    private OrderStatus orderStatus;  // reco

    private String paymentMethod;

    private Boolean paymentProcessed;

    private LocalDateTime lastUpdated;

    private LocalDateTime expirationDate;  // reco

    List<SalesOrderDetailDTO> salesOrderDetail;

}
