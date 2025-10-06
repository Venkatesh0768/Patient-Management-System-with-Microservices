package org.pm.patientservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExitsException(EmailAlreadyExistException ex) {
        log.warn("Email address already Exits {}" , ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message" , "Email address already in use");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String , String>> handlePatientNotFoundException(PatientNotFoundException ex){
        log.warn("The User not Found with id {}" , ex.getMessage());
        Map<String , String> errors = new HashMap<>();
        errors.put("Message" , "The User not Found with id ");
        return ResponseEntity.badRequest().body(errors);
    }
}
