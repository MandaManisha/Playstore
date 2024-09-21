package com;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.dto.ReviewDTO;

@FeignClient(name="review", url = "http://localhost:9090")
public interface ReviewFeignClient {

	@GetMapping("/reviews/get/{appId}")
	//List<ReviewDTO> getReviews(@PathVariable Long appId);
	List<ReviewDTO> getReviews(@PathVariable Long appId);
     	
}
