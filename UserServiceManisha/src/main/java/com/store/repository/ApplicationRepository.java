package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

	List<Application> findByAppNameContaining(String appName);

	List<Application> findByCategory(String category);

	List<Application> findByRatingGreaterThanEqual(Double rating);

}
