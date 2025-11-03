package com.ahmed.inventoryservice.repo;

import com.ahmed.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource
public interface InventoryRepo extends JpaRepository<Inventory, String> {
}
