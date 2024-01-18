package com.oxuegen.notification.service;

import com.oxuegen.clients.NotificationRequest;
import com.oxuegen.notification.model.Notification;
import com.oxuegen.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void saveNotification(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .message(notificationRequest.message())
                        .sent_at(LocalDateTime.now())
                        .sender("Oxuegen")
                        .to_customer_email(notificationRequest.to_customer_email())
                        .to_customer_id(notificationRequest.to_customer())
                        .build()
        );
    }
}
