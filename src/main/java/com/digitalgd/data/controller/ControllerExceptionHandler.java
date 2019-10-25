package com.digitalgd.data.controller;

import com.digitalgd.data.dto.Error;
import com.digitalgd.data.exceptions.EntityNotFoundException;
import com.digitalgd.data.exceptions.ListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleBindException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("500", "entity not found"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleBindException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("400", "illegal parameter"));
    }

    @ExceptionHandler(ListNotFoundException.class)
    public ResponseEntity<Error> handleBindException(ListNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("500", "list not found"));
    }
}
