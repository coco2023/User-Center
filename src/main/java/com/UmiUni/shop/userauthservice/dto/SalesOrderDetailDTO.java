package com.UmiUni.shop.userauthservice.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class SalesOrderDetailDTO {

    private Long salesOrderDetailId;

    private String salesOrderSn;

    private String skuCode;  // Assuming skuCode is a unique identifier but not a foreign key

    private Long supplierId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal discount;

    private BigDecimal lineTotal;

}
