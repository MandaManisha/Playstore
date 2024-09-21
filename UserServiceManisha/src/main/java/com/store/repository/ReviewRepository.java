package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByApplicationAppId(Long appId);
}