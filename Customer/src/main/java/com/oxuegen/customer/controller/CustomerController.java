package com.oxuegen.customer.controller;

import com.oxuegen.customer.request.CustomerRegistrationRequest;
import com.oxuegen.customer.service.CustomerService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest){
        log.info("New customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }

}
