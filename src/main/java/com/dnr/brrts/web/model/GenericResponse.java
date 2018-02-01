package com.dnr.brrts.web.model;

public class GenericResponse<T> {
    private String status;
    private String message;
    private T data;

    public GenericResponse() {
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
