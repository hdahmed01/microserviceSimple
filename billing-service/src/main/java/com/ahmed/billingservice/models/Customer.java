package com.ahmed.billingservice.models;

import lombok.*;

@Getter @Setter @ToString @Builder @AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String email;
}
