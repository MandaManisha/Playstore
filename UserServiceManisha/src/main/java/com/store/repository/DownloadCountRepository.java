package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.DownloadCount;


@Repository
public interface DownloadCountRepository extends JpaRepository<DownloadCount, Long> {

    // Method to find DownloadCount by application ID
    DownloadCount findByApplicationAppId(Long appId);
}