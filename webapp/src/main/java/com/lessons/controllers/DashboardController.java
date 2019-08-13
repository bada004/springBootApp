package com.lessons.controllers;


import com.lessons.models.ReportDTO;
import com.lessons.services.DashboardDao;
import com.lessons.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.Map;

@Controller("com.lessons.controllers.DashboardController")
public class DashboardController {
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Resource
    private DashboardDao dashboardDao;

    public DashboardController(){
        logger.debug("DashboardController Started...");
    }

    @Resource
    public ReportService reportService;

    @PostConstruct
    private void dashboardControllerPostConstruct() {
        logger.debug("dashboardControllerPostConstruct Started...");
    }

    /*************************************************************************
     * getDateTime()
     * @return JSON string that holds the date/time
     *************************************************************************/
    @RequestMapping(value = "/api/dashboard/time", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getDateTime() {
        logger.debug("getDashboardDetails() started.");

        // Get the date/time from the database
        String sDateTime = dashboardDao.getDatabaseTime();

        // Return the date/time string as plain-text
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body(sDateTime);
    }

    @RequestMapping(value = "/api/dashboard/nextval", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getNextVal() {
        logger.debug("getNextVal() started.");

        // Get the nexdtVal from the database
        Integer iNextVal = dashboardDao.getNextVal();
        String result = "" + iNextVal;

        // Return the nextVal
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body(result);
    }

    @RequestMapping(value = "/api/dashboard/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> addNewRecord(@RequestParam(name="description") String description,
                                          @RequestParam(name="priority") Integer priority) {
        logger.debug("addNewRecord started.");

        //
        dashboardDao.addNewRecord(description, priority);

        // Return a status code if everything is good, otherwise just blow up
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body("");
    }

// The code is delete is not working
    @RequestMapping(value = "/api/dashboard/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteRecord(@PathVariable(name="reportId") Integer reportId) {
        logger.debug("deleteReport started.");

        //
        dashboardDao.deleteRecord(reportId);

        // Return a status code if everything is good, otherwise just blow up
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body("");
    }

    // The code is GET is not working
    @RequestMapping(value = "/api/dashboard/reports/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getReport(@PathVariable(name="id") Integer reportId) {
        logger.debug("getReport started.");

        Map<String, Object> resultingReport = reportService.getReport(reportId);

        // Return a status code if everything is good, otherwise just blow up
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("resultingReport");
    }

    @RequestMapping(value = "/api/reports/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> add(@RequestBody ReportDTO reportDTO) {
        logger.debug("allParams started.");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reportDTO);
    }

    @RequestMapping(value = "/api/reports/approved", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> approveReport(@RequestParam (name="id") Integer reportId,
                                           @RequestParam (name="approved")boolean reviewed) {
        logger.debug("approved started.");
        if(!reportService.doesIdExist(reportId)) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("Report ID is not found.");
        }
        reportService.approveReport(reportId, reviewed);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("");
    }
}
