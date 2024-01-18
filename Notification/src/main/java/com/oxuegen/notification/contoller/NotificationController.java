package com.oxuegen.notification.contoller;

import com.oxuegen.clients.NotificationRequest;
import com.oxuegen.notification.service.NotificationService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("New notification {}", notificationRequest);
        notificationService.saveNotification(notificationRequest);
    }

}
