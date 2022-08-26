package com.Department.departmentservice.daos.rowmapper;

import com.Department.departmentservice.pojos.DepartmentPojo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDepartmentRowMapper implements RowMapper<DepartmentPojo> {
    @Override
    public DepartmentPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
        DepartmentPojo details = new DepartmentPojo();
        details.setDepartmentId(rs.getInt("id"));
        details.setDepartmentName(rs.getString("department_name"));
        details.setCreatedOn(rs.getString("created_on"));
        details.setModifiedOn(rs.getString("modified_on"));
        return details;
    }
}
