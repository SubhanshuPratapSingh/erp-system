package com.erp.service;

import com.erp.entity.*;
import com.erp.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {

    private final SalesOrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;

    public SalesOrderService(SalesOrderRepository orderRepo,
                             ProductRepository productRepo,
                             CustomerRepository customerRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }

    public SalesOrder createOrder(Long customerId, List<Long> productIds) {

        Customer customer = customerRepo.findById(customerId).orElseThrow();

        List<Product> products = productRepo.findAllById(productIds);

        double total = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        SalesOrder order = new SalesOrder();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setTotalAmount(total);

        return orderRepo.save(order);
    }

    public List<SalesOrder> getAll() {
        return orderRepo.findAll();
    }
}