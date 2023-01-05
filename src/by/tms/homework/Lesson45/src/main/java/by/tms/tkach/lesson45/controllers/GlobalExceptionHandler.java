package by.tms.tkach.lesson45.controllers;

import by.tms.tkach.lesson45.exceptions.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, ResourceNotFoundException.class})
    private ResponseEntity<Object> handleResourceNotFound(Exception ex, ServletWebRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("path", request.getRequest().getRequestURI());

        return new ResponseEntity<>(response,  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    private ResponseEntity<Object> handleMaxUploadFileSize(Exception ex, ServletWebRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("path", request.getRequest().getRequestURI());
        return new ResponseEntity<>(response,  HttpStatus.PAYLOAD_TOO_LARGE);
    }
}

