package com.vsk.mtep.service;

import com.vsk.mtep.dto.LoginRequest;
import com.vsk.mtep.dto.LoginResponse;
import com.vsk.mtep.dto.RegisterRequest;
    public interface AuthService {
    void registerCompany(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}


