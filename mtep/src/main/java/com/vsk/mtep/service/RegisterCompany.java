package com.vsk.mtep.service;
import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsk.mtep.dto.RegisterRequest;
import com.vsk.mtep.entity.Tenant;
import com.vsk.mtep.entity.User;
import com.vsk.mtep.repository.TenantRepository;
import com.vsk.mtep.repository.UserRepository;
@Service
public class RegisterCompany {
    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final PasswordEncoder passwordEncoder;
    public RegisterCompany(UserRepository userRepository,
                           TenantRepository tenantRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerCompany(RegisterRequest request) {

    if (!request.getPassword().equals(request.getConfirmPassword())) {
        throw new RuntimeException("Passwords do not match");
    }

    if (userRepository.existsByEmail(request.getAdminEmail())) {
        throw new RuntimeException("Email already exists");
    }
    Tenant tenant = new Tenant();
    tenant.setCompanyName(request.getCompanyName());
     tenant.setTenantCode("VSK_" + System.currentTimeMillis());
    tenant.setStatus("ACTIVE");
    tenant.setCreatedAt(LocalDateTime.now());
    tenantRepository.save(tenant);
    User admin = new User();
    admin.setName(request.getAdminName());
    admin.setEmail(request.getAdminEmail());
    admin.setPassword(passwordEncoder.encode(request.getPassword()));
    admin.setRole("COMPANY_ADMIN");
    admin.setTenant(tenant);
    userRepository.save(admin);
}
}
