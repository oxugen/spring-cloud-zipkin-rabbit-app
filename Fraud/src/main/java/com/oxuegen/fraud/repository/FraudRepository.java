package com.oxuegen.fraud.repository;

import com.oxuegen.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
