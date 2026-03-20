package com.erp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY orders → ONE customer
    @ManyToOne
    private Customer customer;

    // MANY products in one order
    @ManyToMany
    private List<Product> products;

    private double totalAmount;
}