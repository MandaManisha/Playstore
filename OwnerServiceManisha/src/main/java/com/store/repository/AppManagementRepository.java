package com.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.AppManagement;

@Repository
public interface AppManagementRepository extends JpaRepository<AppManagement, Long> {
    List<AppManagement> findByAppNameContaining(String appName);
    List<AppManagement> findByVisible(Boolean visible);
	Optional<AppManagement> findByAppName(String appName);
	 List<AppManagement> findByOwner_Ownerid(Long ownerid);

}
