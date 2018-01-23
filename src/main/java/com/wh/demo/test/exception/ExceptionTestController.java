package com.wh.demo.test.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionTestController {

	@GetMapping("/test/{id}")
	public String test(@PathVariable(name="id") Integer id) throws MyException {
		
		if(id == 1) {
			throw new MyException("id不能为1");
		}else if(id == 2) {
			throw new MyRuntimeException("id不能为2");
		}
		
		return "SUCCESS";
	}
	
}
