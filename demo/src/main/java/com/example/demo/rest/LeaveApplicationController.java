package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveApplication;
import com.example.demo.service.LeaveApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/leaveApplication")
public class LeaveApplicationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @PostMapping("/applyLeave")
    public ResponseEntity<LeaveApplication> applyLeave(@Valid @RequestBody LeaveApplication leaveApplication){
        long start = System.currentTimeMillis();
        logger.info("Start Method applyLeave ", leaveApplication.getEpfNo(),leaveApplication.getDays());

        LeaveApplication leaveApplicationObj = null;
        try{
            leaveApplicationObj = leaveApplicationService.saveApplication(leaveApplication);
        }catch (Exception e){
            logger.error("Method applyLeave = {}", e);
        }
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method findEmployee | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return ResponseEntity.status(200).body(leaveApplicationObj);
    }

    @PutMapping("/approveLeave/{applicationId}/{user}")
    public ResponseEntity<LeaveApplication> approveLeave(@PathVariable("applicationId") Long applicationId, @PathVariable("user") String user){
        long start = System.currentTimeMillis();
        logger.info("Start Method approveLeave ", applicationId, user);

        LeaveApplication leaveApplicationObj = null;
        try{
            leaveApplicationObj = leaveApplicationService.approveLeave(applicationId, user);
        }catch (Exception e){
            logger.error("Method approveLeave = {}", e);
        }
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method findEmployee | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return ResponseEntity.status(200).body(leaveApplicationObj);
    }

    @PutMapping("/rejectLeaveApplication/{applicationId}/{user}")
    public ResponseEntity<LeaveApplication> rejectLeaveApplication(@PathVariable("applicationId") Long applicationId, @PathVariable("user") String user){
        long start = System.currentTimeMillis();
        logger.info("Start Method rejectLeaveApplication ", applicationId, user);

        LeaveApplication leaveApplicationObj = null;
        try{
            leaveApplicationObj = leaveApplicationService.rejectLeaveApplication(applicationId, user);
        }catch (Exception e){
            logger.error("Method rejectLeaveApplication = {}", e);
        }
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method findEmployee | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return ResponseEntity.status(200).body(leaveApplicationObj);
    }

    @GetMapping("/getLeaves/{startingDate}/{endingDate}")
    public List<LeaveApplication> getLeaves(@PathVariable("startingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startingDate, @PathVariable("endingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endingDate){
        long start = System.currentTimeMillis();
        logger.info("Start Method getLeaves ");

        List<LeaveApplication> leaveApplicationsList = leaveApplicationService.getLeaves(startingDate, endingDate);

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method getEmployees | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return leaveApplicationsList;
    }

    @GetMapping("/getEmployeeLeaves/{epf}/{startingDate}/{endingDate}")
    public List<LeaveApplication> getEmployeeLeaves(@PathVariable("epf") String epf, @PathVariable("startingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startingDate, @PathVariable("endingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endingDate){

        long start = System.currentTimeMillis();
        logger.info("Start Method getEmployeeLeaves ");

        List<LeaveApplication> leaveApplicationsList = leaveApplicationService.getEmployeeLeaves(epf, startingDate, endingDate);

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method getEmployees | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return leaveApplicationsList;
    }

    @GetMapping("/getApprovedEmployeeLeaves/{epf}/{startingDate}/{endingDate}")
    public List<LeaveApplication> getApprovedEmployeeLeaves(@PathVariable("epf") String epf, @PathVariable("startingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startingDate, @PathVariable("endingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endingDate){

        long start = System.currentTimeMillis();
        logger.info("Start Method getApprovedEmployeeLeaves ");

        List<LeaveApplication> leaveApplicationsList = leaveApplicationService.getApprovedEmployeeLeaves(epf, startingDate, endingDate);

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method getApprovedEmployeeLeaves | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return leaveApplicationsList;
    }
}
