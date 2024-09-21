package com.store.service;
import java.util.List;

import com.store.dto.AppManagementDTO;
import com.store.entity.AppManagement;

public interface AppManagementService {
	
	public AppManagement createApplication(AppManagement appManagement);
	public List<AppManagement> searchApplications(String appName);
	public AppManagement getApplicationById(Long appId);
	public AppManagement updateApplication(Long appId, AppManagement appDetails);
	public void deleteApplication(Long appId);
	public void updateVisibility(Long appId, Boolean visible);

    public List<AppManagementDTO> getAppManagementsByOwnerId(Long ownerid); 
	
	

}
