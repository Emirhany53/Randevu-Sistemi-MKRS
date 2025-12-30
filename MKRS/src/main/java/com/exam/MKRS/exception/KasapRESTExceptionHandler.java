package com.exam.MKRS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
 public class KasapRESTExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<KasapErrorResponse> handleException(KasapBulunamadiException exc){
        KasapErrorResponse error = new KasapErrorResponse();

        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}