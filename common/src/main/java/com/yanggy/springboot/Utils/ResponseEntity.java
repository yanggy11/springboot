package com.yanggy.springboot.Utils;

import java.io.Serializable;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public class ResponseEntity implements Serializable {
    private String status = "1";
    private String message;
    private Object data;
    private String error = "00000000";

    public ResponseEntity() { }

    public ResponseEntity(String status) {
        this.status = status;
    }
    public ResponseEntity(Object data) {
        this.data = data;
    }

    public ResponseEntity(String status, String error) {
        this.status = status;
        this.error = error;
    }
    public ResponseEntity(String status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public ResponseEntity(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseEntity(String status, String error, String msg, Object data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
