package com.ahmed.customerservice;

import com.ahmed.customerservice.config.CustomerConfigParams;
import com.ahmed.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.ahmed.customerservice.repos.CustomerRepo;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(CustomerConfigParams.class)
@ComponentScan
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }




    @Bean
    CommandLineRunner start(CustomerRepo customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Ahmed").address("Tunis").email("test@gmail.com").build());

            customerRepository.save(Customer.builder()
                    .name("aziz").address("nabel").email("aziz@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .name("patrik").address("paris").email("patrik@gmail.com").build());
        };
    }
}
