package com.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.customexception.AppManagementAlreadyExistsException;
import com.store.customexception.AppManagementNotFoundException;
import com.store.customexception.InvalidAppManagementInputException;
import com.store.dto.AppManagementDTO;
import com.store.entity.AppManagement;
import com.store.repository.AppManagementRepository;
import com.store.service.AppManagementService;

@Service
public class AppManagementServiceImpl implements AppManagementService {

	@Autowired
	private AppManagementRepository appManagementRepository;

	@Override
	public AppManagement createApplication(AppManagement appManagement) {
		// Validate input
		if (appManagement.getAppName() == null || appManagement.getAppName().isEmpty()) {
			throw new InvalidAppManagementInputException("Application name must not be null or empty");
		}

		// Check if application already exists
		if (appManagementRepository.findByAppName(appManagement.getAppName()).isPresent()) {
			throw new AppManagementAlreadyExistsException(
					"Application with name " + appManagement.getAppName() + " already exists");
		}

		return appManagementRepository.save(appManagement);
	}

	@Override
	public List<AppManagement> searchApplications(String appName) {
		List<AppManagement> apps = appManagementRepository.findByAppNameContaining(appName);
		if (apps.isEmpty()) {
			throw new AppManagementNotFoundException("No applications found with the name: " + appName);
		}
		return apps;
	}

	@Override
	public AppManagement getApplicationById(Long appId) {
		return appManagementRepository.findById(appId)
				.orElseThrow(() -> new AppManagementNotFoundException("Application with ID " + appId + " not found"));
	}

	@Override
	public AppManagement updateApplication(Long appId, AppManagement appDetails) {
		AppManagement app = getApplicationById(appId);

		// Update application details
		app.setAppName(appDetails.getAppName());
		app.setDescription(appDetails.getDescription());
		app.setReleaseDate(appDetails.getReleaseDate());
		app.setVersion(appDetails.getVersion());
		app.setRating(appDetails.getRating());
		app.setGenre(appDetails.getGenre());

		return appManagementRepository.save(app);
	}

	@Override
	public void deleteApplication(Long appId) {
		AppManagement app = getApplicationById(appId); // Ensure app exists before deletion
		appManagementRepository.delete(app);
	}

	@Override
	public void updateVisibility(Long appId, Boolean visible) {
		AppManagement app = getApplicationById(appId);
		app.setVisible(visible);
		appManagementRepository.save(app);
	}

	@Override
	public List<AppManagementDTO> getAppManagementsByOwnerId(Long ownerid) {
		List<AppManagement> appManagements = appManagementRepository.findByOwner_Ownerid(ownerid);
		return appManagements.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private AppManagementDTO convertToDTO(AppManagement appManagement) {
		AppManagementDTO dto = new AppManagementDTO();
		dto.setAppId(appManagement.getAppId());
		dto.setAppName(appManagement.getAppName());
		dto.setCategory(appManagement.getCategory());
		dto.setDescription(appManagement.getDescription());
		dto.setReleaseDate(appManagement.getReleaseDate());
		dto.setVersion(appManagement.getVersion());
		dto.setRating(appManagement.getRating());
		dto.setGenre(appManagement.getGenre());
		return dto;
	}
}
