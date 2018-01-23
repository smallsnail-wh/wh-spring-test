package com.wh.demo.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.wh.demo.test.model.UserEntity;
import com.wh.demo.test.model.UserEntity.UserEntityDetailView;
import com.wh.demo.test.model.UserEntity.UserEntitySimpleView;
import com.wh.demo.test.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@GetMapping("/user/{id}")
	@JsonView(UserEntitySimpleView.class)
	public UserEntity userGet(@PathVariable int id) {
		System.out.println("controller !!");
		UserEntity userEntity = userService.getUserById(id);
		log.debug("The method is ending");
		return userEntity;
	}
	
	@GetMapping("/test")
	public List<String> test(String name,@PageableDefault(size=10,page=1,sort="id",direction=Direction.DESC)Pageable pageable){
		System.out.println(name);
		
		System.out.println(pageable.toString());
		
		List<String> users = new ArrayList<>();
		users.add("1");
		users.add("2");
		users.add("3");
		return users;
	}
	
	@GetMapping(value="/{id:\\d+}")
	@JsonView(UserEntityDetailView.class)
	public UserEntity getInfo(@PathVariable(name="id") int id) {
		UserEntity userEntity = userService.getUserById(id);
		return userEntity;
	}
	
	@PostMapping("/user")
	public UserEntity createUser(@Valid @RequestBody UserEntity userEntity,BindingResult errors) {
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
			System.out.println(123);
		}
		
		System.out.println(userEntity.toString());
		userEntity.setId(1);
		return userEntity;
	}
}
