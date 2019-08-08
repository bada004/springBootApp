package com.lessons.controllers;


import com.lessons.services.DashboardDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Controller("com.lessons.controllers.DashboardController")
public class DashboardController {
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Resource
    private DashboardDao dashboardDao;

    public DashboardController(){
        logger.debug("DashboardController Started...");
    }

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

        // Get the date/time from the database
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

        // Get the date/time from the database
        dashboardDao.addNewRecord(description, priority);

        // Return a status code if everything is good, otherwise just blow up
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body("");
    }

}
