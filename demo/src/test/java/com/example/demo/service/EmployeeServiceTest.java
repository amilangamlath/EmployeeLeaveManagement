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

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder()
                .id(1L)
                .epfNo("2100")
                .fname("Ann").lname("Bravo").department("HRM").contactNo("0777749302").address("Jaffna").authorityLevel(1)
                .build();

        Mockito.when(employeeRepository.findById(1L).get()).thenReturn(employee);
    }

    @Test
    @DisplayName("Get data based on id")
    public void whenValidEmployeeId_thenEmployeeShouldFound() throws EmployeeNotFoundException {

//        Long empId = 1L;

        Employee employee = employeeService.findEmployee(1L);

        assertEquals(1L, employee.getId());
    }
}