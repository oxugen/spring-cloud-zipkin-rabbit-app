package com.oxuegen.clients;

import java.time.LocalDateTime;

public record NotificationRequest(
        Integer to_customer,
        String message,
        String to_customer_email
        ) {
}
