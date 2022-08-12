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

        return ResponseEntity.status(200).body(employeeService.saveEmployee(employee));
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
        logger.info("Start Method getEmployees ");

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method findEmployee | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());

        return ResponseEntity.status(200).body(employeeService.findEmployee(id));
    }

    @GetMapping("/deleteEmplyee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) throws EmployeeNotFoundException {

        return ResponseEntity.status(200).body(employeeService.updateEmployee(id, employee));
    }
}
