package com.store.services;

public interface DownloadService {

    void downloadApplication(Long appId, Long id);

    Long getDownloadCount(Long appId);
    
}