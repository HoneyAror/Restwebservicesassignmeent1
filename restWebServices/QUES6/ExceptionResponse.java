package com.example.Restwebservices;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String mesaage;
    private  String details;

    public ExceptionResponse(Date timestamp, String mesaage, String details) {
        this.timestamp = timestamp;
        this.mesaage = mesaage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMesaage() {
        return mesaage;
    }

    public String getDetails() {
        return details;
    }
}
