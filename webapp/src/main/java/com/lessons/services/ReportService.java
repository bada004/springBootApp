package com.lessons.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

@Service
public class ReportService {
    @Resource
    private DataSource dataSource;

    public Map<String, Object> getReport(int reportId){
        String sql = "select * from reports where id = ?";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        Map<String, Object> result = jt.queryForMap(sql, reportId);
        return result;
    }
}
