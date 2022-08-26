package com.Department.departmentservice.controllers;

import com.Department.departmentservice.pojos.DepartmentPojo;
import com.Department.departmentservice.response.APIResponse;
import com.Department.departmentservice.response.message.CustomSuccessEnum;
import com.Department.departmentservice.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @PostMapping("/add_department")
    public ResponseEntity<APIResponse> addDepartment(@RequestBody DepartmentPojo departmentPojo) {

        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "addDepartment",
                "addDepartment",
                "to add Department",
                "Started",
                departmentPojo
        );
        Map<String, Object> dataObject = new HashMap<>();
        departmentService.addDepartment(departmentPojo);
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "addDepartment",
                "addDepartment",
                "to add Department",
                "Completed",
                departmentPojo
        );
        return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_DEPARTMENT_ADDED, dataObject), HttpStatus.OK);
    }

    @GetMapping("/get_department/{id}")
    DepartmentPojo getDepartment(@PathVariable("id") Integer departmentId) {
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "getDepartment",
                "getDepartment",
                "to get department",
                "Started",
                departmentId
        );
        Map<String, Object> dataObject = new HashMap<>();
        DepartmentPojo departmentPojo = departmentService.getDepartment(departmentId);
        dataObject.put("department_id", departmentPojo.getDepartmentId());
        dataObject.put("department_name", departmentPojo.getDepartmentName());
        dataObject.put("created_on", departmentPojo.getCreatedOn());
        dataObject.put("modified_on", departmentPojo.getModifiedOn());
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "getDepartment",
                "getDepartment",
                "to get department",
                "Completed",
                departmentId
        );
        //return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_FETCH_DEPARTMENT, dataObject), HttpStatus.OK);
        return departmentPojo;
    }


    @PutMapping("/update_department")
    ResponseEntity<APIResponse> updateDepartmentName(@RequestBody DepartmentPojo departmentPojo) {
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "updateDepartmentName",
                "updateDepartmentName",
                "to update department",
                "Started",
                departmentPojo
        );
        Map<String, Object> dataObject = new HashMap<>();
        departmentService.updateDepartment(departmentPojo);
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "updateDepartmentName",
                "updateDepartmentName",
                "to update department",
                "Completed",
                departmentPojo
        );
        return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_DEPARTMENT_UPDATED, dataObject), HttpStatus.OK);
    }

    @DeleteMapping("/delete_department/{id}")
    ResponseEntity<APIResponse> deleteDepartment(@PathVariable("id") Integer departmentId) {
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "deleteDepartment",
                "deleteDepartment",
                "to delete department",
                "Started",
                departmentId
        );
        Map<String, Object> dataObject = new HashMap<>();
        departmentService.deleteDepartment(departmentId);
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Department-Service",
                "deleteDepartment",
                "deleteDepartment",
                "to delete department",
                "Completed",
                departmentId
        );
        return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_DEPARTMENT_DELETED, dataObject), HttpStatus.OK);


    }
}
