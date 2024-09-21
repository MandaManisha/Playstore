package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.dto.OwnerDTO;
import com.store.feignconfig.FeignConfig;




@FeignClient(name = "UserServiceManisha", configuration = FeignConfig.class )
public interface UserFeignClient {
	
	@GetMapping("/users/{ownerid}")
	OwnerDTO GetUserData(@PathVariable("ownerid") Long ownerid);
	
}
