package com.ahmed.billingservice.entities;

import com.ahmed.billingservice.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int quantity;
    private double unitPrice;
    @ManyToOne
    @JsonIgnore
    private Bill bill;
    @Transient
    private Product product;

}
