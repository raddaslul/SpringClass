package com.sparta.selectshop2.repository;

import com.sparta.selectshop2.model.ApiUseTime;
import com.sparta.selectshop2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUseTimeRepository extends JpaRepository<ApiUseTime, Long> {
    Optional<ApiUseTime> findByUser(User user);
}