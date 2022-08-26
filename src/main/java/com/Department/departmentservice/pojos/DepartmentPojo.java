package com.Department.departmentservice.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentPojo {

    private Integer departmentId;
    private String departmentName;
    private String createdOn;
    private String modifiedOn;
}
