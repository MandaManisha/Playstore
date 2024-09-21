package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.dto.NotificationDTO;
import com.notification.entity.Notification;
import com.notification.repo.NotificationRepository;

import java.util.Date;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setAppId(notificationDTO.getAppId());
        notification.setOwnerid(notificationDTO.getOwnerid());
        notification.setMessage(notificationDTO.getMessage());
        notification.setNotificationDate(new Date());

        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByOwnerId(Long ownerid) {
    	
        return notificationRepository.findByOwnerid(ownerid);
    }
}
