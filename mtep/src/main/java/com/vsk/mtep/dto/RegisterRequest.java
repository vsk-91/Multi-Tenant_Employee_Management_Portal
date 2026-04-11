package com.vsk.mtep.dto;
// import lombok.Getter;
// import lombok.Setter;
// @Getter
// @Setter
public class RegisterRequest {
    private String getCompanyName;
    private String getAdminName;
    private String getAdminEmail;
    private String getpassword;
    private String getConfirmPassword;
 public String getCompanyName() {
        return getCompanyName;
    }
    public void setCompanyName(String companyName) {
        this.getCompanyName = companyName;
    }
    public String getAdminName() {
        return getAdminName;
    }
    public void setAdminName(String adminName) {
        this.getAdminName = adminName;
    }
    public String getAdminEmail() {
        return getAdminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.getAdminEmail = adminEmail;
    }
    public String getPassword() {
        return getpassword;
    }
    public void setPassword(String password) {
        this.getpassword = password;
    }
    public String getConfirmPassword() {
        return getConfirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.getConfirmPassword = confirmPassword;
    }
}
