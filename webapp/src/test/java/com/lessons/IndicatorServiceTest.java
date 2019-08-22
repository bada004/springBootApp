//package com.lessons;
//
//import com.lessons.services.IndicatorService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)    // Required to work with JUnit 4
//@SpringBootTest                 // Start up a Spring Application Context
//public class IndicatorServiceTest {
//    private static final Logger logger = LoggerFactory.getLogger(IndicatorServiceTest.class);
//
//    @Resource
//    private IndicatorService indicatorService;
//
//    @Test
//    public void testCase1() {
//        logger.debug("testCase1() started.");
//        Integer totalIndicatorsInDatabase = indicatorService.indicatorCount();
//        assetTrue("This is broke!", (totalIndicatorsInDatabase == 1));
//        // Create an array of filters
//        List<String> filters = Arrays.asList("ID~EQUALS~5");
//
//        // Run the test
//        boolean bIndicatorsAreValid = indicatorService.areIndicatorsValid();
//
//
//        // Newer way of verifying result
////            assertThat("Indicator did not have the expected match", bIndicatorsAreValid, is(Boolean.TRUE));
//
////            logger.debug("testValidFormat1() finished.");
//    }
//
//}
//
