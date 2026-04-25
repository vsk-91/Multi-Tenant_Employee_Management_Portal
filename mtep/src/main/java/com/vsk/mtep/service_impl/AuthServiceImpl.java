package com.vsk.mtep.service_impl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsk.mtep.dto.LoginRequest;
import com.vsk.mtep.dto.LoginResponse;
import com.vsk.mtep.dto.RegisterRequest;
import com.vsk.mtep.entity.Tenant;
import com.vsk.mtep.entity.User;
import com.vsk.mtep.repository.TenantRepository;
import com.vsk.mtep.repository.UserRepository;
import com.vsk.mtep.security.JwtUtil;
import com.vsk.mtep.service.AuthService;
// import java.time.LocalDateTime;
@Service
public class AuthServiceImpl implements AuthService {
    private final TenantRepository tenantRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthServiceImpl(TenantRepository tenantRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                         JwtUtil jwtUtil) {
        this.tenantRepository = tenantRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    @Override
    public void registerCompany(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
        if (userRepository.existsByEmail(request.getAdminEmail())) {
            throw new RuntimeException("Email already exists");
        }
        Tenant tenant = new Tenant();
        tenant.setCompanyName(request.getCompanyName());
        tenant.setStatus("ACTIVE");
        tenantRepository.save(tenant);
        User admin = new User();
        admin.setName(request.getAdminName());
        admin.setEmail(request.getAdminEmail());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setRole("COMPANY_ADMIN");
        admin.setTenant(tenant);
        userRepository.save(admin);
    }
    @Override
    public LoginResponse login(LoginRequest request) {
    // 1. Find user by email
    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));
    // 2. Check password
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid password");
    }

    // 3. Generate JWT token
    String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

    return new LoginResponse(token);
}
}

