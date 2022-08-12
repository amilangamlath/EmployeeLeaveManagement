package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveApplication;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.LeaveApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeaveApplicationServiceTest {

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Get approved Leave data based on EPF and date range")
    public void whenValidEpfDateRange_thenLeaveShouldFound() throws Exception {

    }
}