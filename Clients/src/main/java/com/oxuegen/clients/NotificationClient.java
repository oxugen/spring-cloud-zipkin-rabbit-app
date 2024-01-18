package com.oxuegen.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification"
)
public interface NotificationClient {

    @PostMapping("api/v1/notification")
    public void sendNotification(NotificationRequest notificationRequest);
}
