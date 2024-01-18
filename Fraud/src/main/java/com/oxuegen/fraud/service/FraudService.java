package com.oxuegen.fraud.service;

import com.oxuegen.fraud.entity.FraudCheckHistory;
import com.oxuegen.fraud.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class FraudService{

    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
