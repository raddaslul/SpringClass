package com.sparta.selectshop2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false; // false면 User, true면 Admin
    private String adminToken = "";
}