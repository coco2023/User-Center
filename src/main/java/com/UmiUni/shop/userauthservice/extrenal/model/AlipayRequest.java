package com.UmiUni.shop.userauthservice.extrenal.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class AlipayRequest {

    private BigDecimal amount;

    private String salesOrderSn;

    private String currency;

}
