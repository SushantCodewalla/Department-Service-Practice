
package com.Department.departmentservice.response;


import com.Department.departmentservice.response.message.CustomSuccessEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class APIResponse implements Serializable  {

    private static final long serialVersionUID = -4250483884711227087L;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message_code")
    private Integer messageCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Map data = new HashMap<>();

//    public APIResponse(Boolean status, Integer messageCode, String message) {
//        this.success = status;
//        this.messageCode = messageCode;
//        this.message = message;
//    }
//
//    public APIResponse(Boolean status, Integer messageCode, String message, Map data) {
//        this.success = status;
//        this.messageCode = messageCode;
//        this.message = message;
//        this.data = data;
//    }

    public APIResponse(Boolean status, CustomSuccessEnum successEnum, Map data) {
        this.success = status;
        this.messageCode = successEnum.getMessage_code();
        this.message = successEnum.getMessage();
        this.data = data;
    }

//    public APIResponse(Boolean status, CustomFailureEnum failureEnum, Map data) {
//        this.success = status;
//        this.messageCode = failureEnum.getMessage_code();
//        this.message = failureEnum.getMessage();
//        this.data = data;
//    }

//    public Boolean getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(Boolean success) {
//        this.success = success;
//    }
//
//    public Integer getMessageCode() {
//        return messageCode;
//    }
//
//    public void setMessageCode(Integer messageCode) {
//        this.messageCode = messageCode;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Map getData() {
//        return data;
//    }
//
//    public void setData(Map data) {
//        this.data = data;
//    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "success=" + success +
                ", messageCode=" + messageCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
