package com.example.demo.respository;

import com.example.demo.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication,Long> {

    @Query("select a from LeaveApplication a where a.startingDate >= :startingDate and a.startingDate <= :endingDate")
    List<LeaveApplication> findAllWithEndingDateBeforeAndStartingDateAfter(
            @Param("endingDate") Date endingDate, @Param("startingDate") Date startingDate);

    @Query("select a from LeaveApplication a where a.epfNo = :epf and a.startingDate >= :startingDate and a.startingDate <= :endingDate")
    List<LeaveApplication> findAllWithEndingDateBeforeAndStartingDateAfterWithEPF(String epf,Date endingDate, Date startingDate);

    @Query("select a from LeaveApplication a where a.epfNo = :epf and a.isApproved = true and a.startingDate >= :startingDate and a.startingDate <= :endingDate")
    LeaveApplication[] findAllApprovedWithEndDateAndStartDate(String epf, Date endingDate, Date startingDate);
}
