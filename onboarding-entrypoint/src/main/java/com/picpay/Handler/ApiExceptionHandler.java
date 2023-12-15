package com.picpay.Handler;

import com.picpay.exceptions.CpfAlreadyExists;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CpfAlreadyExists.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage addresNotFoundException(CpfAlreadyExists ex, HttpServletRequest request) {
        ErrorMessage message = ErrorMessage.builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build();
        return message;
    }
}
