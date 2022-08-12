package com.example.demo.service;

import com.example.demo.entity.LeaveApplication;
import com.example.demo.entity.LeaveType;
import com.example.demo.respository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public LeaveType addLeaveType(LeaveType leaveType) {

        return leaveTypeRepository.save(leaveType);
    }

    @Override
    public List<LeaveType> getLeaveTypes() {

        List<LeaveType> leaveTypeList = new ArrayList<LeaveType>();
        for(LeaveType leaveType : leaveTypeRepository.findAll()){
            LeaveType object = new LeaveType(leaveType.getId(), leaveType.getType(), leaveType.getTimePeriod(), leaveType.getNeedApprovalLevels());
            leaveTypeList.add(object);
        }

        return leaveTypeList;

    }

    @Override
    public LeaveType getLeaveTypeByType(int type) {
        LeaveType leaveType = leaveTypeRepository.findById(Long.valueOf(type)).get();
        return leaveType;
    }
}
