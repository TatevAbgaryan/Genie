package com.genie.genie.helper;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import javax.annotation.Resource;

import com.genie.genie.dao.SessionDao;
import com.genie.genie.dao.UserDao;
import com.genie.genie.dao.dom.SessionDom;
import com.genie.genie.dto.SessionDto;
import com.genie.genie.dto.UserDto;
import org.springframework.stereotype.Component;

import com.genie.genie.dao.dom.UserDom;

@Component
public class SessionHelper {

	private static final SecureRandom SECURE_RANDOM = new SecureRandom();
	private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder();

	@Resource
	private SessionDao sessionDao;

	@Resource
	private UserDao userDao;

	@Resource
	private UserHelper userHelper;

	public SessionDto createSessionDto(SessionDom session){
		SessionDto sessionDto = new SessionDto();
		sessionDto.setAuthToken(session.getAuthToken());
		sessionDto.setUser(new UserDto(session.getUser()));
		return sessionDto;
	}

	public String generateNewToken() {
		byte[] randomBytes = new byte[24];
		SECURE_RANDOM.nextBytes(randomBytes);
		return BASE64_ENCODER.encodeToString(randomBytes);
	}
}
