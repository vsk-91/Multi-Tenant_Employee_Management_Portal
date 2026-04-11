package com.vsk.mtep.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private Double salary;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
     public Employee() {}
     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }
     public String getEmail() {
         return email;
     }
     public void setEmail(String email) {
         this.email = email;
     }
     public String getDepartment() {
         return department;
     }
     public void setDepartment(String department) {
         this.department = department;
     }
     public Double getSalary() {
         return salary;
     }
     public void setSalary(Double salary) {
         this.salary = salary;
     }
     public Tenant getTenant() {
         return tenant;
     }
     public void setTenant(Tenant tenant) {
         this.tenant = tenant;
     }
     public boolean isActive() {
    return active;
     }
    public void setActive(boolean active) {
        this.active = active;
    }
     
}
