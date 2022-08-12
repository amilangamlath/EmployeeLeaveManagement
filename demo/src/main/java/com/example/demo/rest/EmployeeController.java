package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String returnHello(){
        return "Hellow Amila";
    }

    @PostMapping("/SaveEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        long start = System.currentTimeMillis();
        logger.info("Start Method saveEmployee ", employee.getFname(),employee.getEpfNo());

        Employee employeeObj = null;
        try{
           employeeObj = employeeService.saveEmployee(employee);
        }catch (Exception e){
            logger.error("Method saveEmployee = {}", e);
        }
        return ResponseEntity.status(200).body(employeeObj);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        long start = System.currentTimeMillis();
        logger.info("Start Method getEmployees ");

        List<Employee> employeeList = employeeService.getEmployees();

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method getEmployees | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return employeeList;
    }

    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        long start = System.currentTimeMillis();
        logger.info("Start Method findEmployee ");

        Employee employee = null;
        try{
           employee = employeeService.findEmployee(id);
        }catch (Exception e){
            logger.error("Method findEmployee = {}", e);
        }

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method findEmployee | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());

        return ResponseEntity.status(200).body(employee);
    }

    @GetMapping("/deleteEmplyee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        logger.info("Start Method deleteEmployee ");
        try{
        employeeService.deleteEmployee(id);
        }catch (Exception e){
            logger.error("Method deleteEmployee = {}", e);
        }

        return "Deleted.!";
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) throws EmployeeNotFoundException {
        long start = System.currentTimeMillis();
        logger.info("Start Method updateEmployee ");

        Employee employeeObj = null;
        try{
            employeeObj = employeeService.updateEmployee(id, employee);
        }catch (Exception e){
            logger.error("Method findEmployee = {}", e);
        }
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method findEmployee | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return ResponseEntity.status(200).body(employeeObj);
    }
}
