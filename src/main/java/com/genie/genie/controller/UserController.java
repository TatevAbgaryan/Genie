package com.genie.genie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.genie.genie.dto.MasterDto;
import com.genie.genie.dto.UserDto;
import com.genie.genie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public String hello(HttpSession session) {
		return "Hello";
	}

	@PostMapping("/user/register")
	public UserDto registerAsUser(@Valid @RequestBody UserDto userDto,
								  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		return userService.registerAsUser(userDto);
	}
	
	@PostMapping("/master/register")
	public MasterDto registerAsMaster(@Valid @RequestBody MasterDto masterDto,
									  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		return userService.registerAsMaster(masterDto);
	}
}
