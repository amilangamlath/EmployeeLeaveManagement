package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.respository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Get data based on id")
    public void whenValidEmployeeId_thenEmployeeShouldFound() throws EmployeeNotFoundException {

        Employee employee = employeeService.findEmployee(2L);
        System.out.println("Test employee"+employee.toString());
        assertEquals(2L, employee.getId());
    }
}