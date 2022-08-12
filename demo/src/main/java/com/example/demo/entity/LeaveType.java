package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveType{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please add Leave Type")
    private String type;
    private String timePeriod;

    @PositiveOrZero
    private int needApprovalLevels;

//    public LeaveType(Long id, String type, String timePeriod, int needApprovalLevels) {
//        this.id = id;
//        this.type = type;
//        this.timePeriod = timePeriod;
//        this.needApprovalLevels = needApprovalLevels;
//    }
//
//    public LeaveType() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getTimePeriod() {
//        return timePeriod;
//    }
//
//    public void setTimePeriod(String timePeriod) {
//        this.timePeriod = timePeriod;
//    }
//
//    public int getNeedApprovalLevels() {
//        return needApprovalLevels;
//    }
//
//    public void setNeedApprovalLevels(int needApprovalLevels) {
//        this.needApprovalLevels = needApprovalLevels;
//    }
//
//    @Override
//    public String toString() {
//        return "LeaveType{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", timePeriod='" + timePeriod + '\'' +
//                ", needApprovalLevels=" + needApprovalLevels +
//                '}';
//    }
}
