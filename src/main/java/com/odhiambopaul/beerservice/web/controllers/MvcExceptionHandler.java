package com.odhiambopaul.beerservice.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {
  public ResponseEntity<List<String>> validEntityErrors(ConstraintViolationException exc) {
    List<String> errorList = new ArrayList<>(exc.getConstraintViolations().size());
    exc.getConstraintViolations().forEach(error -> errorList.add(error.toString()));
    return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
  }
}
