package com.vsk.mtep.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
public class RegisterRequest {
    @NotBlank(message = "Company name is required")
    private String companyName;
    @NotBlank(message = "Admin name is required")
    private String adminName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String adminEmail;
    @NotBlank(message = "Password is required")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}$",
        message = "Password must contain uppercase, lowercase, number and minimum 6 characters"
    )
    private String password;
    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}