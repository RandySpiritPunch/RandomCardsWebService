package org.card.random.exception;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResource resourceNotFoundExceptionHandle(HttpServletRequest req, ResourceNotFoundException e) {
        ExceptionHandlerExceptionResolver resolver = new ExceptionHandlerExceptionResolver();
        return new ErrorResource(getStatusCode(), e.getMessage(), req.getRequestURL().toString());
    }

    private String getStatusCode() {
        return HttpStatus.BAD_REQUEST.value() +"-"+HttpStatus.BAD_REQUEST.getReasonPhrase();
    }

}