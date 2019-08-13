package com.lessons.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
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


    /**
     * TODO
     * @param id
     *
     * @param approved
     *
     */
    public void approveReport(Integer id, boolean approved) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("approved", approved);
        params.put("reportId", id );
        NamedParameterJdbcTemplate np = new NamedParameterJdbcTemplate(this.dataSource);
        String sql = "UPDATE reports set reviewed=:approved where id = :reportId";
        np.update(sql, params);
    }

    /**
     * TODO Check if an Id exists
     * @param reportId
     *
     * @return
     *
     */
    public boolean doesIdExist(Integer reportId)
    {
        String sql = "select id from reports where id = ?";
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        SqlRowSet rs = jt.queryForRowSet(sql, reportId);
        return rs.next();
    }
}
