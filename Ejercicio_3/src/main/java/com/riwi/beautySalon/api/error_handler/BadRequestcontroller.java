package com.riwi.beautySalon.api.error_handler;

import java.util.ArrayList;
import java.util.List;

import com.riwi.beautySalon.utils.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.beautySalon.api.dto.errors.BaseErrorResponse;
import com.riwi.beautySalon.api.dto.errors.ErrorsResponse;

@RestControllerAdvice
@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class BadRequestcontroller {
    public BaseErrorResponse handleBadRequest(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(errors).build();
    }
    @ExceptionHandler(BadRequestException.class)
    public BaseErrorResponse badRequest (BadRequestException exception) {
        List<String> errors = new ArrayList<>();

        errors.add(exception.getMessage());

        return ErrorsResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(errors).build();
    }
}
