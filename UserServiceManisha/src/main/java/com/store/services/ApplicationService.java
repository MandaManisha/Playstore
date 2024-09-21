package com.store.services;

import java.util.List;
import java.util.Optional;

import com.store.entity.Application;


public interface ApplicationService {
	
	public List<Application> searchApplications(String appName);
	public Optional<Application> getApplicationById(Long appId);

    public void transferAppManagementsToApplications(Long ownerid);
    
    List<Application> getApplicationsByCategory(String category);
    List<Application> getApplicationsByRating(Double rating);


}
