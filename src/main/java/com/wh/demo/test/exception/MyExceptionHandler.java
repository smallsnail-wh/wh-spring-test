package com.wh.demo.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(MyException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handlerMyException(MyException ex) {
		Map<String,Object> result = new HashMap<>();
		result.put("message", ex.getMessage());
		result.put("error type", "MyException");
		return result;
	}
	
	@ExceptionHandler(MyRuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handlerMyRuntimeException(MyRuntimeException ex) {
		Map<String,Object> result = new HashMap<>();
		result.put("message", ex.getMessage());
		result.put("error type", "MyRuntimeException");
		return result;
	}
}
