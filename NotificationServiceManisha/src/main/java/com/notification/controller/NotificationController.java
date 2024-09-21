package com.notification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.notification.dto.NotificationDTO;
import com.notification.entity.Notification;
import com.notification.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Notification createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.createNotification(notificationDTO);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Notification> getNotificationsByOwnerId(@PathVariable Long ownerId) {
        return notificationService.getNotificationsByOwnerId(ownerId);
    }
}