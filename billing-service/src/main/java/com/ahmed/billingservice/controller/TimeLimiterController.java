package com.ahmed.billingservice.controller;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class TimeLimiterController {




    @GetMapping("/slow")
    @TimeLimiter(name = "slowService", fallbackMethod = "slowFallback")
    public CompletableFuture<String> callSlowService() {
        return CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            return "Service Response";
        });
    }

    public CompletableFuture<String> slowFallback(Throwable e) {
        return CompletableFuture.completedFuture("⚠ Service too slow — fallback response");
    }
}
