package com.genie.genie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.genie.genie.dto.SessionDto;
import com.genie.genie.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genie.genie.exception.AppException;
import com.genie.genie.exception.MessageEnum;
import com.genie.genie.dto.UserDto;
import com.genie.genie.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private SessionService sessionService;
	
	@PostMapping("/login")
	public SessionDto login(@Valid @RequestBody UserDto user,
							HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		return sessionService.login(user);
	}
}
