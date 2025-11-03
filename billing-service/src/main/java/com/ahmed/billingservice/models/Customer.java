package com.ahmed.billingservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String email;
}
