package com.ahmed.billingservice.repo;

import com.ahmed.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BillRepo extends JpaRepository<Bill, Long> {

    List<Bill> findBillByCustomerId(Long customerId);
}
