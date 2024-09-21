package com.store.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OwnerFeignClient;
import com.store.dto.AppManagementDTO;
import com.store.entity.Application;
import com.store.repository.ApplicationRepository;
import com.store.services.ApplicationService;

@Service
public class ApplicationServiceImp implements ApplicationService {

	@Autowired
	private OwnerFeignClient ownerFeignClient;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<Application> searchApplications(String appName) {
		return applicationRepository.findByAppNameContaining(appName);
	}

	@Override
	public Optional<Application> getApplicationById(Long appId) {
		return applicationRepository.findById(appId);
	}

	@Override
	public void transferAppManagementsToApplications(Long ownerid) {

		List<AppManagementDTO> appManagementDTOs = ownerFeignClient.getAppManagementsByOwnerId(ownerid);

		for (AppManagementDTO dto : appManagementDTOs) {
			Application application = new Application();
			application.setAppId(dto.getAppId());
			application.setAppName(dto.getAppName());
			application.setCategory(dto.getCategory());
			application.setDescription(dto.getDescription());
			application.setReleaseDate(dto.getReleaseDate());
			application.setVersion(dto.getVersion());
			application.setRating(dto.getRating());
			application.setGenre(dto.getGenre());

			applicationRepository.save(application);
		}
	}

	@Override
	public List<Application> getApplicationsByCategory(String category) {
		return applicationRepository.findByCategory(category);
	}

	@Override
	public List<Application> getApplicationsByRating(Double rating) {
		return applicationRepository.findByRatingGreaterThanEqual(rating);
	}
}
