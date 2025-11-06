package com.ahmed.billingservice;

import com.ahmed.billingservice.entities.Bill;
import com.ahmed.billingservice.entities.ProductItem;
import com.ahmed.billingservice.feign.CustomerRestClient;
import com.ahmed.billingservice.feign.ProductRestClient;
import com.ahmed.billingservice.models.Customer;
import com.ahmed.billingservice.models.Product;
import com.ahmed.billingservice.repo.BillRepo;
import com.ahmed.billingservice.repo.ProductItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(BillRepo billRepo,
                             ProductItemRepo   productItemRepo,
                             CustomerRestClient customerRestClient,
                             ProductRestClient productRestClient) {
        return args -> {
            Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();
            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .BillingDate(new Date())
                        .customerId(customer.getId()).
                        build();
                billRepo.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder().
                                    bill(bill).
                                    unitPrice(product.getPrice())
                            .productId(product.getId())
                                    .quantity(1+new Random().nextInt(10)).build();
                    productItemRepo.save(productItem);
                });
            });
        };
    }
}
