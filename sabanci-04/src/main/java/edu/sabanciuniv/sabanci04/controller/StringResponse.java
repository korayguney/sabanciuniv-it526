package edu.sabanciuniv.sabanci04.controller;

public class StringResponse {
    public String message;

    public StringResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
