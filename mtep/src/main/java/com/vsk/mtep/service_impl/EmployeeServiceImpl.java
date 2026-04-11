package com.vsk.mtep.service_impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vsk.mtep.entity.Employee;
import com.vsk.mtep.entity.User;
import com.vsk.mtep.repository.EmployeeRepository;
import com.vsk.mtep.repository.UserRepository;
import com.vsk.mtep.service.EmployeeService;
// import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    // 🔥 Get logged-in user
   private User getCurrentUser() {
    return (User) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
}

    // ✅ CREATE (AUTO TENANT FIX)
    @Override
    public Employee createEmployee(Employee employee) {
        User user = getCurrentUser();

        employee.setTenant(user.getTenant()); // 🔥 secure
        return employeeRepository.save(employee);
    }

    // ✅ GET (PAGINATION + SEARCH)
    @Override
    public Page<Employee> getEmployees(int page, int size, String search) {

        User user = getCurrentUser();

        Pageable pageable = PageRequest.of(page, size);

        if (search != null && !search.isEmpty()) {
            return employeeRepository
                    .findByTenantIdAndNameContainingIgnoreCase(
                            user.getTenant().getId(),
                            search,
                            pageable
                    );
        }

        return employeeRepository
                .findByTenantId(user.getTenant().getId(), pageable);
    }

    // ✅ UPDATE
    @Override
    public Employee updateEmployee(Long id, Employee updated) {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(updated.getName());
        emp.setEmail(updated.getEmail());

        return employeeRepository.save(emp);
    }

    // ✅ DELETE (SOFT DELETE optional)
    @Override
    public void deleteEmployee(Long id) {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // OPTION 1: Hard delete
        // employeeRepository.delete(emp);

        // OPTION 2: Soft delete (recommended)
        emp.setActive(false);
        employeeRepository.save(emp);
    }
}