package com.example.spring3project.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private HttpStatus status;
    private int errorCode;
    private String errorMessage;

}
