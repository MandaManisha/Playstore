package com.notification.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notification.entity.Notification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByOwnerid(Long ownerid);
}