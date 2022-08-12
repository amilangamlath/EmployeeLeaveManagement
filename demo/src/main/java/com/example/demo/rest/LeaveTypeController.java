package com.example.demo.rest;

import com.example.demo.entity.LeaveApplication;
import com.example.demo.entity.LeaveType;
import com.example.demo.service.LeaveTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/v1/leaveType")
public class LeaveTypeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeaveTypeService leaveTypeService;

    @PostMapping("/addLeaveType")
    public ResponseEntity<LeaveType> addLeaveType(@Valid @RequestBody LeaveType leaveType){
        long start = System.currentTimeMillis();
        logger.info("Start Method addLeaveType ", leaveType.getType(),leaveType.getNeedApprovalLevels());

        return ResponseEntity.status(200).body(leaveTypeService.addLeaveType(leaveType));

    }

    @GetMapping("/getLeaveTypes")
    public List<LeaveType> getLeaveTypes(){
        long start = System.currentTimeMillis();
        logger.info("Start Method getLeaveTypes ");

        List<LeaveType> leaveTypeList = leaveTypeService.getLeaveTypes();

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method getLeaveTypes | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());
        return leaveTypeList;
    }

    @GetMapping("/getLeaveType/{type}")
    public ResponseEntity<LeaveType> getLeaveType(@PathVariable("leaveType") int type){
        long start = System.currentTimeMillis();
        logger.info("Start Method getLeaveType ");

        LeaveType leaveTp = leaveTypeService.getLeaveTypeByType(type);

        Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
        logger.info("End Method getLeaveType | response={} | duration={}:{}:{}:{}", duration.toHours(),
                duration.toMinutes(), duration.getSeconds(), duration.toMillis());

        return ResponseEntity.status(200).body(leaveTp);
    }
}
