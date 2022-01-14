package com.example.hib_03_web.exception;

public class HbException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 5555559786754072975L;
    private String mess;
    public HbException() {}
    // TODO Auto-generated constructor st
    public HbException(String mess) {
        super();
        this.mess = mess;
    }
    public String getMessage() {
        return this.mess;
    }


}
