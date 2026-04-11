package com.vsk.mtep.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vsk.mtep.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByTenantId(Long tenantId);
    Page<Employee> findByTenantId(Long tenantId, Pageable pageable);

Page<Employee> findByTenantIdAndNameContainingIgnoreCase(
        Long tenantId, String name, Pageable pageable);
}
