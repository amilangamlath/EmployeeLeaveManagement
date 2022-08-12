package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public  Employee saveEmployee(Employee employee);

    public List<Employee> getEmployees();

    public Employee findEmployee(Long id) throws EmployeeNotFoundException;

    public void deleteEmployee(Long id);

    public Employee updateEmployee(Long id, Employee employee) throws EmployeeNotFoundException;
}
