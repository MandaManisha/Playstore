package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.dto.AppManagementDTO;
import com.store.feignconfig.FeignConfig;

import java.util.List;

@FeignClient(name = "OwnerServiceManisha", url = "http://localhost:9091", configuration = FeignConfig.class)
public interface OwnerFeignClient {

    @GetMapping("/owner/applications/{ownerid}/appmanagements")
    List<AppManagementDTO> getAppManagementsByOwnerId(@PathVariable("ownerid") Long ownerid);
}