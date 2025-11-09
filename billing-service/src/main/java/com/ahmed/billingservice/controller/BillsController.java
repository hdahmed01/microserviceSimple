package com.ahmed.billingservice.controller;

import com.ahmed.billingservice.entities.Bill;
import com.ahmed.billingservice.feign.CustomerRestClient;
import com.ahmed.billingservice.feign.ProductRestClient;
import com.ahmed.billingservice.repo.BillRepo;
import com.ahmed.billingservice.repo.ProductItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillsController {

    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;
    private final BillRepo billRepo;
    private final ProductItemRepo productItemRepo;

    @GetMapping(path = "/bills/{id}")
    public Bill findBillById(@PathVariable Long id) {
        Bill bill = billRepo.findById(id).get();
        bill.setCustomer(customerRestClient.FindCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> productItem.setProduct(productRestClient.getProductById(productItem.getProductId())));
        return bill;
    }
    @GetMapping(path = "/bills/customer/{id}")
    public List<Bill> findBillsByCustomerId(@PathVariable Long id) {
        List<Bill> bills=billRepo.findBillByCustomerId(id);
        bills.forEach(bill ->
        {
            bill.setCustomer(customerRestClient.FindCustomerById(bill.getCustomerId()));
            bill.getProductItems().forEach(productItem -> productItem.setProduct(productRestClient.getProductById(productItem.getProductId())));
        } );
        return bills;
    }
}
