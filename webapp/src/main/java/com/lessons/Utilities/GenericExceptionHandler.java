package com.lessons.Utilities;

import com.lessons.controllers.DashboardController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.PostConstruct;

@ControllerAdvice
public class GenericExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GenericExceptionHandler.class);

    @Value("${development.mode}")
    private Boolean developmentMode;

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        logger.error("Something Broke!", exception);

        if (developmentMode) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(exception.getLocalizedMessage());
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("Something Broke!");
        }
    }

    public GenericExceptionHandler() {
        logger.debug("Inside Constructor");
    }

    @PostConstruct
    public void GenericExceptionHandlerPostConstruct() {
        logger.debug("Inside PostConstruct");
    }
}
