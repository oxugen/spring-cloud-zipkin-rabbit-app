package com.oxuegen.fraud.contoller;

import com.oxuegen.clients.FraudCheckResponse;
import com.oxuegen.fraud.service.FraudService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudService fraudService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudService
                .isFraudulentCustomer(customerId);
        log.info("fraud check for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
