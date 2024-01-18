package com.oxuegen.customer.service;

import com.oxuegen.clients.FraudCheckResponse;
import com.oxuegen.clients.FraudClient;
import com.oxuegen.clients.NotificationClient;
import com.oxuegen.clients.NotificationRequest;
import com.oxuegen.customer.model.Customer;
import com.oxuegen.customer.repository.CustomerRepository;
import com.oxuegen.customer.request.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudulent()){
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to portal...",
                                customer.getFirstName())
                )
        );

        // todo: check if email valid
        // todo: check if email not taken
    }
}
