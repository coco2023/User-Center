package com.UmiUni.shop.userauthservice.extrenal.salesOrder;

import com.UmiUni.shop.userauthservice.entity.SalesOrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "SALES-ORDER-SERVICE/api/v1/salesOrderDetails")
public interface SalesOrderDetailService {

    // create salesOrderDetail
    @PostMapping
    public ResponseEntity<SalesOrderDetail> createSalesOrderDetail(@RequestBody SalesOrderDetail salesOrderDetail);

    // salesOrderDetail
    @GetMapping("/salesOrderSn/{salesOrderSn}")
    public ResponseEntity<List<SalesOrderDetail>> getSalesOrderDetailsBySalesOrderSn(@PathVariable("salesOrderSn") String salesOrderSn);

}
