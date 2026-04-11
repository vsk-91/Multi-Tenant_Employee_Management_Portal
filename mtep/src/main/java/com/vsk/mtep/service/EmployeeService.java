package com.vsk.mtep.service;

import org.springframework.data.domain.Page;

import com.vsk.mtep.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Page<Employee> getEmployees(int page, int size, String search);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
