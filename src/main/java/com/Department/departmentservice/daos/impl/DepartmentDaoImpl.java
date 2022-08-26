package com.Department.departmentservice.daos.impl;

import com.Department.departmentservice.daos.DepartmentDao;
import com.Department.departmentservice.daos.rowmapper.GetDepartmentRowMapper;
import com.Department.departmentservice.pojos.DepartmentPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addDepartment(DepartmentPojo detail) {
        try {
            String sql = "INSERT INTO department(department_name, created_on,modified_on) values(?, now(), now())";
            log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                    "addDepartment",
                    detail.getDepartmentId(),
                    "addDepartment",
                    " to add department data",
                    sql);
            return jdbcTemplate.update(sql, detail.getDepartmentName());
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DepartmentPojo getDepartment(int departmentId) {
        String sql = "SELECT * FROM department where id =" + departmentId;
        DepartmentPojo data = jdbcTemplate.queryForObject(sql, new GetDepartmentRowMapper());
        log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                "getDepartment",
                departmentId,
                "getDepartment",
                " to retrieve department data",
                sql);
        return data;
    }

    @Override
    public int updateDepartment(DepartmentPojo detail) {
        String sql = "UPDATE department SET department_name = ?,modified_on = now() WHERE id =" + detail.getDepartmentId();
        log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                "updateDepartment",
                detail.getDepartmentId(),
                "updateDepartment",
                " to update department data",
                sql);
        return jdbcTemplate.update(sql, detail.getDepartmentName());
    }

    @Override
    public void deleteDepartment(int departmentId) {
        try {
            String sql = "DELETE FROM department WHERE id = ?";
            jdbcTemplate.update(sql, departmentId);
            log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                    "deleteDepartment",
                    departmentId,
                    "deleteDepartment",
                    " to delete department data",
                    sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
