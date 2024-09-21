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
import org.springframework.web.bind.annotation.RestController;

import com.NotificationServiceFeignClient;
import com.store.dto.NotificationDTO;
import com.store.dto.OwnerDTO;
import com.store.dto.ReviewDTO;
import com.store.entity.Owner;
import com.store.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@Autowired
    private NotificationServiceFeignClient notificationServiceFeignClient;

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/get")
	public List<Owner> getAllOwners() {
		return ownerService.getAllOwners();
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/get/{id}")
	public Owner getOwnerById(@PathVariable Long id) {
		return ownerService.getOwnerById(id);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/save")
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerService.createOwner(owner);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@PutMapping("/update/{id}")
	public Owner updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
		return ownerService.updateOwner(id, ownerDetails);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/delete/{id}")
	public void deleteOwner(@PathVariable Long id) {
		ownerService.deleteOwner(id);
	}

	@GetMapping("/{ownerid}")
	public OwnerDTO getOwnerDataWithUserData(@PathVariable("ownerid") Long ownerid) {

		OwnerDTO employeeDTO = ownerService.getOwnerDataWithUserData(ownerid);

		return employeeDTO;
	}

	@GetMapping("/downloads/{appId}")
	public ResponseEntity<Long> getDownloadCount(@PathVariable Long appId) {
		return ResponseEntity.ok(ownerService.getDownloadCount(appId));
	}
	
	@GetMapping("/reviews/{appId}")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long appId) {
        return ResponseEntity.ok(ownerService.getReviews(appId));
    }
	
	@PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationServiceFeignClient.sendNotification(notificationDTO);
        return ResponseEntity.ok("Notification sent successfully");
    }

}
