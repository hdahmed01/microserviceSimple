package com.ahmed.billingservice.feign;

import com.ahmed.billingservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB",fallbackMethod = "getDefaultCustomer")
    @Retry(name = "customerRetry")
    Customer FindCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name ="customerServiceCB",fallbackMethod = "getDefaultCustomers")
    @Retry(name = "customerRetry")
    PagedModel<Customer> getAllCustomers();


    default Customer getDefaultCustomer(Long id,Exception e) {
        return Customer.builder()
                .id(id)
                .email("default@email.com")
                .address("default adresse")
                .name("default name").build();
    }
    default PagedModel<Customer> getDefaultCustomers(Exception e) {
        return PagedModel.empty();
    }
}
