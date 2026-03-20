package com.erp.controller;

import com.erp.entity.SalesOrder;
import com.erp.service.SalesOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
public class SalesOrderController {

    private final SalesOrderService service;

    public SalesOrderController(SalesOrderService service) {
        this.service = service;
    }

    @PostMapping
    public SalesOrder createOrder(
            @RequestParam Long customerId,
            @RequestParam List<Long> productIds) {

        return service.createOrder(customerId, productIds);
    }

    @GetMapping
    public List<SalesOrder> getAll() {
        return service.getAll();
    }
}