package com.example.demo.service;

import com.example.demo.entity.LeaveApplication;
import java.util.Date;
import java.util.List;

public interface LeaveApplicationService {

    public LeaveApplication saveApplication(LeaveApplication leaveApplication);

    public List<LeaveApplication> getLeaves(Date startingDate, Date endingDate);

    public List<LeaveApplication> getEmployeeLeaves(String epf, Date startingDate, Date endingDate);

    public LeaveApplication approveLeave(Long applicationId, String user);

    public LeaveApplication rejectLeaveApplication(Long applicationId, String user);

    public List<LeaveApplication> getApprovedEmployeeLeaves(String epf, Date startingDate, Date endingDate);
}
