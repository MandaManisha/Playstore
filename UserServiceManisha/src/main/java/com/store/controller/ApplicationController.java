package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Application;
import com.store.services.ApplicationService;


@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    
    @GetMapping("/get/byname")
    public ResponseEntity<List<Application>> searchApplications(@RequestParam String appName) {
        return ResponseEntity.ok(applicationService.searchApplications(appName));
    }

    
    @GetMapping("/getbyid{appId}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long appId) {
        return applicationService.getApplicationById(appId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    } 
    
    @PostMapping("/transfer/{ownerid}")
    public void transferAppManagements(@PathVariable Long ownerid) {
        applicationService.transferAppManagementsToApplications(ownerid);
    }
    
    @GetMapping("/bycategory")
    public ResponseEntity<List<Application>> getApplicationsByCategory(@RequestParam String category) {
        return ResponseEntity.ok(applicationService.getApplicationsByCategory(category));
    }

    // New endpoint for filtering by rating
    @GetMapping("/byrating")
    public ResponseEntity<List<Application>> getApplicationsByRating(@RequestParam Double rating) {
        return ResponseEntity.ok(applicationService.getApplicationsByRating(rating));
    }
}
