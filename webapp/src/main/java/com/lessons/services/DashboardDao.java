package com.lessons.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Service
public class DashboardDao
{
    private static final Logger logger = LoggerFactory.getLogger(DashboardDao.class);

    @Resource
    private DataSource dataSource;

    public DashboardDao()
    {
        logger.debug("DashboardDao() Constructor called");
    }

    @PostConstruct
    public void dashboardDAOPostConstruct() {
        logger.debug("dashboardDAOPostConstruct called");
    }

    public String getDatabaseTime()
    {
        logger.debug("getDatabaseTime() started.");

        // Run a SQL query to get the current date time  //TODO SQL Select Call - See the Dashboard controller to see how its used in the browser
        String sql = "Select NOW()";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        String sDateTime = jt.queryForObject(sql, String.class);
        logger.debug("Database Time is {}", sDateTime);

        return sDateTime;
    }

//    TODO SQL GET Example - Controller is on DashboardContoller.java
    public Integer getNextVal() {
        String sql = "select nextval('seq_table_ids')";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        Integer iNextVal = jt.queryForObject(sql, Integer.class);
        logger.debug("The nextVal {}", iNextVal);
        return iNextVal;
    }

//    TODO SQL POST Example with multiple passed in parameters - Controller is on DashboardContoller.java
    public void addNewRecord(String desc, Integer priority) {
        String sql = "insert into reports (id, description, priority) values (nextval('seq_table_ids'), ?, ?)";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        jt.update(sql, desc, priority);
    }

}
