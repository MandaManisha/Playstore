package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.store.dto.NotificationDTO;

@FeignClient(name = "notification-service", url = "http://localhost:9092")
public interface NotificationServiceFeignClient {

    @PostMapping("/notifications")
    void sendNotification(@RequestBody NotificationDTO notificationDTO);
}