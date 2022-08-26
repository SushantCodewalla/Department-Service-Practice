package com.Department.departmentservice.daos;

import com.Department.departmentservice.pojos.DepartmentPojo;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentDao {
    int addDepartment(DepartmentPojo detail);

    DepartmentPojo getDepartment(int departmentId);

    int updateDepartment(DepartmentPojo detail);

    void deleteDepartment(int departmentId);
}
