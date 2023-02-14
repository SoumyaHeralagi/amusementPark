package com.cg.park.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class GlobalException {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
	 @ExceptionHandler(value =UserNotFoundException.class)
	 public ResponseEntity<Object> exception(UserNotFoundException exception) { 
		 return new ResponseEntity<>("User details not Found",HttpStatus.NOT_FOUND); 
		 }
	 
	 @ExceptionHandler(value =RideNotFoundException.class)
	 public ResponseEntity<Object> exception(RideNotFoundException exception) { 
		 return new ResponseEntity<>("rides not Found",HttpStatus.NOT_FOUND); 
		 }
	 
	 @ExceptionHandler(value =BookingNotFoundException.class)
	 public ResponseEntity<Object> exception(BookingNotFoundException exception) { 
		 return new ResponseEntity<>("booking details not Found",HttpStatus.NOT_FOUND); 
		 }
}
