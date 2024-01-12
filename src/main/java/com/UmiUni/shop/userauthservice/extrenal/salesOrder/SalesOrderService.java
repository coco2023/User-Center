package com.UmiUni.shop.userauthservice.extrenal.salesOrder;

import com.UmiUni.shop.userauthservice.entity.SalesOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SALES-ORDER-SERVICE/api/v1/salesOrders")
public interface SalesOrderService {

    // create SalesOrder
    @PostMapping
    public ResponseEntity<SalesOrder> createSalesOrder(@RequestBody SalesOrder salesOrder);

    @GetMapping("/salesOrderSn/{salesOrderSn}")
    public ResponseEntity<SalesOrder> getSalesOrderBySalesOrderSn(@PathVariable("salesOrderSn") String salesOrderSn);

}
