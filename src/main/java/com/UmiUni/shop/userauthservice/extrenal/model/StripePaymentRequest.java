package com.UmiUni.shop.userauthservice.extrenal.model;

import com.UmiUni.shop.userauthservice.entity.SalesOrder;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class StripePaymentRequest {

    private String token;

    private SalesOrder salesOrder;

}
