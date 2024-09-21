package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.AppManagementDTO;
import com.store.entity.AppManagement;
import com.store.service.AppManagementService;


@RestController
@RequestMapping("/owner/applications")
public class AppManagementController {

    @Autowired
    private AppManagementService appManagementService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/save")
    public ResponseEntity<AppManagement> createApplication(@RequestBody AppManagement appManagement) {
        return ResponseEntity.ok(appManagementService.createApplication(appManagement));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get/byAppName")
    public ResponseEntity<List<AppManagement>> searchApplications(@RequestParam String appName) {
        return ResponseEntity.ok(appManagementService.searchApplications(appName));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get/{appId}")
    public AppManagement getApplicationById(@PathVariable Long appId) {
        return appManagementService.getApplicationById(appId);
           
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/update/{appId}")
    public ResponseEntity<AppManagement> updateApplication(@PathVariable Long appId, @RequestBody AppManagement appDetails) {
        return ResponseEntity.ok(appManagementService.updateApplication(appId, appDetails));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/delete/{appId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long appId) {
        appManagementService.deleteApplication(appId);
        return ResponseEntity.ok().build();
    }
    
   

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/update/{id}/visibility")
    public ResponseEntity<Void> updateVisibility(@PathVariable Long id, @RequestParam Boolean visible) {
        appManagementService.updateVisibility(id, visible);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{ownerid}/appmanagements")
    public List<AppManagementDTO> getAppManagementsByOwnerId(@PathVariable Long ownerid) {
        return appManagementService.getAppManagementsByOwnerId(ownerid);
    }
}