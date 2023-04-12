package com.example.spring3project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail onException(RuntimeException ex){
        ProblemDetail pd=ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ex.getMessage());
        pd.setTitle("student Not Found");
        pd.setType(URI.create("https://api.customer-portal.com/erros/not-found"));
        pd.setProperty("timestamp", Instant.now());
        pd.setTitle("jsnj");
        return pd;
    }

}
