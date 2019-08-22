package com.lessons.services;

import com.lessons.models.IndicatorCountDTO;
import com.lessons.models.IndicatorDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Service
public class IndicatorService {
    @Resource
    private DataSource dataSource;

    public Integer indicatorCount()
    {
        String sql = "select count(id) as ind_count from indicators";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        SqlRowSet rs = jt.queryForRowSet(sql);
        Integer count = 0;
        if (rs.next()) {
            count = rs.getInt("ind_count");
        }
        return count;
    }


    public List<IndicatorDTO> getAllIndicators() {
        String sql = "select * from indicators";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        BeanPropertyRowMapper rowMapper = new BeanPropertyRowMapper(IndicatorDTO.class);
        List<IndicatorDTO> listofIndicators = jt.query(sql,rowMapper);
        return (listofIndicators);
    }
}
