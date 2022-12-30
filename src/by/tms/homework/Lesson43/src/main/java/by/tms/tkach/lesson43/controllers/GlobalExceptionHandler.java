package by.tms.tkach.lesson43.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound(HttpServletRequest request, Exception e) {
        log.debug("Exception occurred while calling {}: {}", request.getRequestURI(), e);
        return "404";
    }
}
