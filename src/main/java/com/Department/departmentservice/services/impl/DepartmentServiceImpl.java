package com.Department.departmentservice.services.impl;

import com.Department.departmentservice.daos.DepartmentDao;
import com.Department.departmentservice.pojos.DepartmentPojo;
import com.Department.departmentservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public int addDepartment(DepartmentPojo detail) {
        return departmentDao.addDepartment(detail);
    }

    @Override
    public DepartmentPojo getDepartment(int departmentId) {
        DepartmentPojo data = departmentDao.getDepartment(departmentId);
        return data;
    }

    @Override
    public int updateDepartment(DepartmentPojo detail) {
        return departmentDao.updateDepartment(detail);
    }

    @Override
    public void deleteDepartment(int departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }
}
