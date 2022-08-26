package com.Department.departmentservice.response.message;


public enum CustomSuccessEnum {

	SUCCESS_DEPARTMENT_ADDED(11012,"Department Added Successfully."),
	SUCCESS_DEPARTMENT_DELETED(11013,"Department Deleted Successfully."),
	SUCCESS_DEPARTMENT_UPDATED(11013,"Department Updated Successfully."),
	SUCCESS_FETCH_DEPARTMENT(11014,"Retrieve Department Successfully."),
	;


    private int message_code;

    private String message;

    private CustomSuccessEnum(int message_code, String message) {
        this.message_code = message_code;
        this.message = message;
    }
    public int getMessage_code() {
		return message_code;
	}
	public String getMessage() {
		return message;
	}

	@Override
    public String toString() {
        return this.message_code + " : " + this.message;
    }
}
