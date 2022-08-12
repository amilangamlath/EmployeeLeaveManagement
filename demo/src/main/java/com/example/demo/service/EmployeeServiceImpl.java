package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {

        List<Employee> employeeList = new ArrayList();
        for(Employee emp : employeeRepository.findAll()){
            Employee employee = new Employee(emp.getId(),emp.getEpfNo(),emp.getFname(),emp.getLname(),
                    emp.getNic(), emp.getAddress(), emp.getContactNo(), emp.getDepartment(), emp.getDesignation(), emp.getAuthorityLevel());

            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee findEmployee(Long id) throws EmployeeNotFoundException {
       Optional<Employee> employee = employeeRepository.findById(id);

       if(!employee.isPresent()){
           throw new EmployeeNotFoundException("Employee not available");
       }
       return employee.get();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> empObj = employeeRepository.findById(id);

        if(!empObj.isPresent()){
            throw new EmployeeNotFoundException("Employee not available");
        }

        Employee emp = empObj.get();

        if(Objects.nonNull(employee.getFname()) && !"".equalsIgnoreCase(employee.getFname())){
            emp.setFname(employee.getFname());
        }

        if(Objects.nonNull(employee.getLname()) && !"".equalsIgnoreCase(employee.getLname())){
            emp.setLname(employee.getLname());
        }

        if(Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress())){
            emp.setAddress(employee.getAddress());
        }

        if(Objects.nonNull(employee.getEpfNo()) && !"".equalsIgnoreCase(employee.getEpfNo())){
            emp.setEpfNo(employee.getEpfNo());
        }

        if(Objects.nonNull(employee.getContactNo()) && !"".equalsIgnoreCase(employee.getContactNo())){
            emp.setContactNo(employee.getContactNo());
        }

        if(Objects.nonNull(employee.getNic()) && !"".equalsIgnoreCase(employee.getNic())){
            emp.setContactNo(employee.getNic());
        }

        return employeeRepository.save(emp);
    }


}
