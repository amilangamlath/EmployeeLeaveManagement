package com.example.demo.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please add EPF Number")
    private String epfNo;

    @NotBlank(message = "Please add First Name")
    @Length(max = 20 , min = 1)
    private String fname;

    @NotBlank(message = "Please add Last Name")
    @Length(max = 20 , min = 1)
    private String lname;

    @NotBlank(message = "Please add Nic")
    @Length(max = 12 , min = 10)
    private String nic;
    private String address; //contactNo

    @Length(max = 10 , min = 10)
    private String contactNo;
    private String department;
    private String designation;

    @PositiveOrZero
    private int authorityLevel;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
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
//    public String getFname() {
//        return fname;
//    }
//
//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//
//    public String getLname() {
//        return lname;
//    }
//
//    public void setLname(String lname) {
//        this.lname = lname;
//    }
//
//    public String getNic() {
//        return nic;
//    }
//
//    public void setNic(String nic) {
//        this.nic = nic;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getContactNo() {
//        return contactNo;
//    }
//
//    public void setContactNo(String contactNo) {
//        this.contactNo = contactNo;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public int getAuthorityLevel() {
//        return authorityLevel;
//    }
//
//    public void setAuthorityLevel(int authorityLevel) {
//        this.authorityLevel = authorityLevel;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", epfNo='" + epfNo + '\'' +
//                ", fname='" + fname + '\'' +
//                ", lname='" + lname + '\'' +
//                ", nic='" + nic + '\'' +
//                ", address='" + address + '\'' +
//                ", contactNo='" + contactNo + '\'' +
//                ", department='" + department + '\'' +
//                ", designation='" + designation + '\'' +
//                ", authorityLevel=" + authorityLevel +
//                '}';
//    }

//    public Employee() {
//    }
//
//    public Employee(Long id, String epfNo, String fname, String lname, String nic, String address, String contactNo,
//                    String department, String designation, int authorityLevel) {
//        this.id = id;
//        this.epfNo = epfNo;
//        this.fname = fname;
//        this.lname = lname;
//        this.nic = nic;
//        this.address = address;
//        this.contactNo = contactNo;
//        this.department = department;
//        this.designation = designation;
//        this.authorityLevel = authorityLevel;
//    }
}
