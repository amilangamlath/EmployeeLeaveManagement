package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveApplication;
import com.example.demo.entity.LeaveType;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.LeaveApplicationRepository;
import com.example.demo.respository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService{

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public LeaveApplication saveApplication(LeaveApplication leaveApplication) {
        return leaveApplicationRepository.save(leaveApplication);
    }

    @Override
    public List<LeaveApplication> getLeaves(Date startingDate, Date endingDate) {
        List<LeaveApplication> leaveApplicationList = new ArrayList();

        for(LeaveApplication leaveApplication : leaveApplicationRepository.findAllWithEndingDateBeforeAndStartingDateAfter(endingDate, startingDate)){
            LeaveApplication leaveApplicationDTO = new LeaveApplication();

            leaveApplicationDTO.setApplicationId(leaveApplication.getApplicationId());
            leaveApplicationDTO.setEpfNo(leaveApplication.getEpfNo());
            leaveApplicationDTO.setDays(leaveApplication.getDays());
            leaveApplicationDTO.setReason(leaveApplication.getReason());
            leaveApplicationDTO.setStartingDate(leaveApplication.getStartingDate());
            leaveApplicationDTO.setEndingDate(leaveApplication.getEndingDate());
            leaveApplicationDTO.setComeBackDate(leaveApplication.getComeBackDate());
            leaveApplicationDTO.setWorkAssignee(leaveApplication.getWorkAssignee());

            leaveApplicationList.add(leaveApplicationDTO);
        }

        return leaveApplicationList;
    }

    @Override
    public List<LeaveApplication> getEmployeeLeaves(String epf, Date startingDate, Date endingDate) {

        List<LeaveApplication> leaveApplicationList = new ArrayList();

        for(LeaveApplication leaveApplication : leaveApplicationRepository.findAllWithEndingDateBeforeAndStartingDateAfterWithEPF(epf, endingDate, startingDate)){

            LeaveApplication leaveApplicationDTO = new LeaveApplication(leaveApplication.getApplicationId(), leaveApplication.getEpfNo(),
                    leaveApplication.getDays(), leaveApplication.getStartingDate(), leaveApplication.getEndingDate(),
                    leaveApplication.getComeBackDate(), leaveApplication.getWorkAssignee(), leaveApplication.getReason(),
                    leaveApplication.getLeaveType(), leaveApplication.getAprovalStatus(),leaveApplication.isLeaveApplied(),
                    leaveApplication.getDate(), leaveApplication.isApproved(), leaveApplication.isActive());

            leaveApplicationList.add(leaveApplicationDTO);
        }

        return leaveApplicationList;
    }

    @Override
    public LeaveApplication approveLeave(Long applicationId, String user) {

        LeaveApplication leaveApplication = leaveApplicationRepository.findById(applicationId).get();
        LeaveType leaveType = leaveTypeRepository.findById(Long.valueOf(leaveApplication.getLeaveType())).get();

        Employee emp = employeeRepository.findByEpfNo(user);
        System.out.println("emp.getAuthorityLevel()-"+emp.getAuthorityLevel());

        if((leaveApplication.getAprovalStatus() <= emp.getAuthorityLevel()) && (leaveType.getNeedApprovalLevels() <= emp.getAuthorityLevel() )){
            leaveApplication.setAprovalStatus(emp.getAuthorityLevel());
            leaveApplication.setApproved(true);
        }else if (leaveApplication.getAprovalStatus() <= emp.getAuthorityLevel()){
            leaveApplication.setAprovalStatus(emp.getAuthorityLevel());
        }
        return leaveApplicationRepository.save(leaveApplication);
    }

    @Override
    public LeaveApplication rejectLeaveApplication(Long applicationId, String user) {

        LeaveApplication leaveApplication = leaveApplicationRepository.findById(applicationId).get();

        Employee emp = employeeRepository.findByEpfNo(user);
        System.out.println("emp.getAuthorityLevel()-"+emp.getAuthorityLevel());

        if(leaveApplication.getAprovalStatus() <= emp.getAuthorityLevel() && leaveApplication.isApproved() == false
                && leaveApplication.isActive() == true){
            leaveApplication.setApproved(false);
            leaveApplication.setActive(false);
        }

        return leaveApplicationRepository.save(leaveApplication);
    }

    @Override
    public List<LeaveApplication> getApprovedEmployeeLeaves(String epf, Date startingDate, Date endingDate) {

        List<LeaveApplication> leaveApplicationList = new ArrayList();

        for(LeaveApplication leaveApplication : leaveApplicationRepository.findAllApprovedWithEndDateAndStartDate(epf, endingDate, startingDate)){

            LeaveApplication leaveApplicationDTO = new LeaveApplication(leaveApplication.getApplicationId(), leaveApplication.getEpfNo(),
                    leaveApplication.getDays(), leaveApplication.getStartingDate(), leaveApplication.getEndingDate(),
                    leaveApplication.getComeBackDate(), leaveApplication.getWorkAssignee(), leaveApplication.getReason(),
                    leaveApplication.getLeaveType(), leaveApplication.getAprovalStatus(),leaveApplication.isLeaveApplied(),
                    leaveApplication.getDate(), leaveApplication.isApproved(), leaveApplication.isActive());

            leaveApplicationList.add(leaveApplicationDTO);
        }

        return leaveApplicationList;
    }
}
