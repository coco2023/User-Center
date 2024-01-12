package com.UmiUni.shop.userauthservice.model;

import com.UmiUni.shop.userauthservice.dto.SalesOrderDetailDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class OrderCreationRequest {
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private String billingAddress;
    private String paymentMethod;
    private List<SalesOrderDetailDTO> orderDetails; // Assuming you have a DTO for order details

}
