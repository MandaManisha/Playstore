package com.store.feignconfig;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.store.security.jwt.JwtUtils;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String token = jwtUtils.generateJwtToken(authentication);
            requestTemplate.header("Authorization", "Bearer " + token);
        }
    }
}
