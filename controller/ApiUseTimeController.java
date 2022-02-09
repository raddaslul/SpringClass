package com.sparta.selectshop2.controller;

import com.sparta.selectshop2.model.ApiUseTime;
import com.sparta.selectshop2.model.UserRoleEnum;
import com.sparta.selectshop2.repository.ApiUseTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiUseTimeController {
    private ApiUseTimeRepository apiUseTimeRepository;

    @Autowired
    public ApiUseTimeController(ApiUseTimeRepository apiUseTimeRepository) {
        this.apiUseTimeRepository = apiUseTimeRepository;
    }

    @Secured(UserRoleEnum.Authority.ADMIN)
    @GetMapping("/api/use/time")
    public List<ApiUseTime> getAllApiUseTime() {
        return apiUseTimeRepository.findAll();
    }
}
