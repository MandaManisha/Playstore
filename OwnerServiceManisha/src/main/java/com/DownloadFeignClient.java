package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="download", url = "http://localhost:9090")
public interface DownloadFeignClient {
	
	@GetMapping("/downloads/getcount/{appId}")
    Long getDownloadCount(@PathVariable Long appId);
}
