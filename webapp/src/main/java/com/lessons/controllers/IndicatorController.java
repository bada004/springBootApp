package com.lessons.controllers;

import com.lessons.models.IndicatorCountDTO;
import com.lessons.models.IndicatorDTO;
import com.lessons.models.ReportDTO;
import com.lessons.services.DashboardDao;
import com.lessons.services.IndicatorService;
import com.lessons.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndicatorController {
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);


    @Resource
    public IndicatorService indicatorService;

    @RequestMapping(value = "/api/indicator/count", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> add() {
        logger.debug("IndicatorCount started.");

        Integer count = indicatorService.indicatorCount();
        IndicatorCountDTO indicatorCountDTO = new IndicatorCountDTO();
        indicatorCountDTO.setTotal_records(count);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(indicatorCountDTO);
    }

    @RequestMapping(value = "/api/indicator/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> all() {
        logger.debug("IndicatorAll started.");

        List<IndicatorDTO> listofDTOs = indicatorService.getAllIndicators();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listofDTOs);
    }
}
