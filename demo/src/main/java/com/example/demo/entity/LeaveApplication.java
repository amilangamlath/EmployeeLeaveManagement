package com.example.demo.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveApplication{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;
    @NotBlank(message = "Please add EPF Number")
    private String epfNo;
    private double days;

    @FutureOrPresent
    private Date startingDate;
    @FutureOrPresent
    private Date endingDate;

    private Date comeBackDate;
    private String workAssignee;

    @Length(max = 100 , min = 2)
    private String reason;
    @PositiveOrZero
    private int leaveType;
    @PositiveOrZero
    private int aprovalStatus;
    private boolean isLeaveApplied;
    private Date date;
    private boolean isApproved;
//    private int needApprovelLevel;
    private boolean isActive;

//    public LeaveApplication() {
//    }

//    public LeaveApplication(Long applicationId, String epfNo, double days, Date startingDate, Date endingDate,
//                            Date comeBackDate, String workAssignee, String reason, int leaveType, int aprovalStatus,
//                            boolean isLeaveApplied, Date date, boolean isApproved, boolean isActive) {
//        this.applicationId = applicationId;
//        this.epfNo = epfNo;
//        this.days = days;
//        this.startingDate = startingDate;
//        this.endingDate = endingDate;
//        this.comeBackDate = comeBackDate;
//        this.workAssignee = workAssignee;
//        this.reason = reason;
//        this.leaveType = leaveType;
//        this.aprovalStatus = aprovalStatus;
//        this.isLeaveApplied = isLeaveApplied;
//        this.date = date;
//        this.isApproved = isApproved;
////        this.needApprovelLevel = needApprovelLevel;
//        this.isActive = isActive;
//    }

    public LeaveApplication(Long applicationId, String epfNo, double days, Date startingDate) {
        this.epfNo = epfNo;
        this.days = days;
        this.startingDate = startingDate;
    }

//    public Long getApplicationId() {
//        return applicationId;
//    }
//
//    public void setApplicationId(Long applicationId) {
//        this.applicationId = applicationId;
//    }
//
//    public String getEpfNo() {
//        return epfNo;
//    }
//
//    public void setEpfNo(String epfNo) {
//        this.epfNo = epfNo;
//    }
//
//    public double getDays() {
//        return days;
//    }
//
//    public void setDays(double days) {
//        this.days = days;
//    }
//
//    public Date getStartingDate() {
//        return startingDate;
//    }
//
//    public void setStartingDate(Date startingDate) {
//        this.startingDate = startingDate;
//    }
//
//    public Date getEndingDate() {
//        return endingDate;
//    }
//
//    public void setEndingDate(Date endingDate) {
//        this.endingDate = endingDate;
//    }
//
//    public Date getComeBackDate() {
//        return comeBackDate;
//    }
//
//    public void setComeBackDate(Date comeBackDate) {
//        this.comeBackDate = comeBackDate;
//    }
//
//    public String getWorkAssignee() {
//        return workAssignee;
//    }
//
//    public void setWorkAssignee(String workAssignee) {
//        this.workAssignee = workAssignee;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public int getLeaveType() {
//        return leaveType;
//    }
//
//    public void setLeaveType(int leaveType) {
//        this.leaveType = leaveType;
//    }
//
//    public int getAprovalStatus() {
//        return aprovalStatus;
//    }
//
//    public void setAprovalStatus(int aprovalStatus) {
//        this.aprovalStatus = aprovalStatus;
//    }
//
//    public boolean isLeaveApplied() {
//        return isLeaveApplied;
//    }
//
//    public void setLeaveApplied(boolean leaveApplied) {
//        isLeaveApplied = leaveApplied;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public boolean isApproved() {
//        return isApproved;
//    }
//
//    public void setApproved(boolean approved) {
//        isApproved = approved;
//    }

//    public int getNeedApprovelLevel() {
//        return needApprovelLevel;
//    }

//    public void setNeedApprovelLevel(int needApprovelLevel) {
//        this.needApprovelLevel = needApprovelLevel;
//    }

//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
//
//    @Override
//    public String toString() {
//        return "LeaveApplication{" +
//                "applicationId=" + applicationId +
//                ", epfNo='" + epfNo + '\'' +
//                ", days=" + days +
//                ", startingDate=" + startingDate +
//                ", endingDate=" + endingDate +
//                ", comeBackDate=" + comeBackDate +
//                ", workAssignee='" + workAssignee + '\'' +
//                ", reason='" + reason + '\'' +
//                ", leaveType=" + leaveType +
//                ", aprovalStatus=" + aprovalStatus +
//                ", isLeaveApplied=" + isLeaveApplied +
//                ", date=" + date +
//                ", isApproved=" + isApproved +
//                ", isActive=" + isActive +
//                '}';
//    }
}
