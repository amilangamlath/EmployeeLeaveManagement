package com.example.demo.service;

import com.example.demo.entity.LeaveApplication;
import com.example.demo.entity.LeaveType;

import java.util.List;

public interface LeaveTypeService {
   public LeaveType addLeaveType(LeaveType leaveType);

   public List<LeaveType> getLeaveTypes();

   public LeaveType getLeaveTypeByType(int leaveType);
}
