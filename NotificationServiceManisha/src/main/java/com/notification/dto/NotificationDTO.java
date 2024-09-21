package com.notification.dto;

import java.util.Date;

public class NotificationDTO {

    private Long ownerid;
    private Long appId;
    private String message;
    private Date notificationDate;
	public Long getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

    
}
