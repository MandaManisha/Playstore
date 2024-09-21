package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.services.DownloadService;


@RestController
@RequestMapping("/downloads")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @PostMapping("/{appId}/save/{id}")
    public ResponseEntity<String> downloadApplication(@PathVariable Long appId, @PathVariable Long id) {
        downloadService.downloadApplication(appId, id);
        return ResponseEntity.ok("Download successful");
    }

    @GetMapping("/getcount/{appId}")
    public ResponseEntity<Long> getDownloadCount(@PathVariable Long appId) {
        Long count = downloadService.getDownloadCount(appId);
        return ResponseEntity.ok(count);
    }
}
