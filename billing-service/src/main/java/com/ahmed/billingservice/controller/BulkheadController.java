package com.ahmed.billingservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BulkheadController {

    @GetMapping("/bulk")
    @Bulkhead(name = "bulkService", type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "bulkFallback")
    public String callBulkService() throws InterruptedException {
        Thread.sleep(10000); // simulate processing
        return "Processed";
    }

    public String bulkFallback(Throwable e) {
        return "⚠ Too many concurrent requests — fallback response";
    }
}