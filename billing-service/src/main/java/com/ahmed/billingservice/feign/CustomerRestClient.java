package com.ahmed.billingservice.feign;

import com.ahmed.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer FindCustomerById(String customerId);

    @GetMapping("/customers")
    PagedModel<Customer> getAllCustomers();
}
