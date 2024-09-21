package com.store.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.Application;
import com.store.entity.DownloadCount;
import com.store.entity.User;
import com.store.repository.ApplicationRepository;
import com.store.repository.DownloadCountRepository;
import com.store.repository.UserRepository;
import com.store.services.DownloadService;



@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadCountRepository downloadCountRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void downloadApplication(Long appId, Long id) {
        Application application = applicationRepository.findById(appId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Increment download count
        DownloadCount downloadCount = downloadCountRepository.findByApplicationAppId(appId);
        if (downloadCount == null) {
            downloadCount = new DownloadCount();
            downloadCount.setApplication(application);
            downloadCount.setCount(1L);
        } else {
            downloadCount.setCount(downloadCount.getCount() + 1);
        }

        downloadCountRepository.save(downloadCount);
    }

    @Override
    public Long getDownloadCount(Long appId) {
        DownloadCount downloadCount = downloadCountRepository.findByApplicationAppId(appId);
        return downloadCount != null ? downloadCount.getCount() : 0L;
    }
}