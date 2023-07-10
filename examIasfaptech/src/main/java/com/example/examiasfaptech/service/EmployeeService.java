package com.example.examiasfaptech.service;

import com.example.examiasfaptech.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> findAllEmployee();
}
