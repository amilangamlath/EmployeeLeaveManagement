package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveApplication;
import com.example.demo.respository.LeaveApplicationRepository;
import com.example.demo.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.*;

@RestController
@RequestMapping("/v1/report")
public class reportGenerator {

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @GetMapping("/leave/{epf}/{startingDate}/{endingDate}")
    public ResponseEntity<byte[]> getEmployeeRecordReport(@PathVariable("epf") String epf, @PathVariable("startingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startingDate, @PathVariable("endingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endingDate) {

        List<LeaveApplication> leaves= leaveApplicationService.getApprovedEmployeeLeaves(epf, startingDate, endingDate);
        List<LeaveApplication> empLst = new ArrayList<LeaveApplication>();
        try {
            // create employee data

            Iterator iterator = leaves.iterator();
            while(iterator.hasNext()){//check if iterator has the elements
                LeaveApplication application = (LeaveApplication) iterator.next();
                LeaveApplication emp1 = new LeaveApplication(application.getApplicationId(), application.getEpfNo(), application.getDays(), application.getStartingDate());

                System.out.println("application.getDays()-"+application.getDays());
                empLst.add(emp1);
            }

            System.out.println("empLst-"+empLst.toString());
            //dynamic parameters required for report
            Map<String, Object> empParams = new HashMap<String, Object>();
            empParams.put("CompanyName", "My Company");
            empParams.put("employeeData", new JRBeanCollectionDataSource(empLst));

            JasperPrint empReport =
                    JasperFillManager.fillReport
                            (
                                    JasperCompileManager.compileReport(
                                            ResourceUtils.getFile("classpath:employees-details.jrxml")
                                                    .getAbsolutePath()) // path of the jasper report
                                    , empParams // dynamic parameters
                                    , new JREmptyDataSource()
                            );

            HttpHeaders headers = new HttpHeaders();
            //set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "employees-details.pdf");
            //create the report in PDF format
            return new ResponseEntity<byte[]>
                    (JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
