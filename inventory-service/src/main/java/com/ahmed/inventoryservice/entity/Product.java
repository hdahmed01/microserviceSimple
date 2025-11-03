package com.ahmed.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
