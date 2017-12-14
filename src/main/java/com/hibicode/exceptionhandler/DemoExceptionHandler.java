package com.hibicode.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RepositoryRestController
public class DemoExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> constraintViolationException(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream().map(c -> new Error(c.getMessage())).collect(Collectors.toList());
    }
	
	@Getter
	@RequiredArgsConstructor
	public static class Error {
		private final String message;
	}
	
}