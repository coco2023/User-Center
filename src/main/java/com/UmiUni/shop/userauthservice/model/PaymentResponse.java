package com.UmiUni.shop.userauthservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class PaymentResponse { // complete payment

    private String status;

    private String transactionId;

    private String description;

    private String errorMesg;

    private String approvalUrl;

}
