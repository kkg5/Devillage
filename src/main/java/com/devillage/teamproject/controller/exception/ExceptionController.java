package com.devillage.teamproject.controller.exception;

import com.devillage.teamproject.exception.BusinessLogicException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<ErrorResponse> customException(BusinessLogicException exception) {
        int statusCode = exception.getExceptionCode().getStatus();

        ErrorResponse body = ErrorResponse.builder()
                .code(String.valueOf(statusCode))
                .message(exception.getExceptionCode().getMessage())
                .validation(exception.getValidation())
                .build();

        return ResponseEntity.status(statusCode).body(body);
    }
}
