package com.genie.genie.helper;

import java.util.Date;

import com.genie.genie.dao.UserDao;
import com.genie.genie.dao.dom.MasterDom;
import com.genie.genie.dao.dom.UserDom;
import com.genie.genie.dto.MasterDto;
import com.genie.genie.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.genie.genie.exception.AppException;
import com.genie.genie.exception.MessageEnum;

@Component
public class UserHelper {
	
	@Autowired
	private UserDao userDao;

	public void validateUserRegistration(UserDto userDto) {

		UserDom user = userDao.findByEmail(userDto.getEmail());

		if(userDto.getEmail().isEmpty()) {
			throw new AppException(MessageEnum.USER_EMPTY_EMAIL);
		}
		
		if (user != null) {
			throw new AppException(MessageEnum.USER_EMAIL_EXISTS);
		}

	}
	
	public UserDom createUserDom(UserDto userDto) {
		UserDom userDom = new UserDom();
		userDom.setUsername(userDto.getUsername());
		userDom.setPassword(userDto.getPassword());
		userDom.setEmail(userDto.getEmail());
		Date now = new Date(System.currentTimeMillis());
		userDom.setCreatedOn(now);
		userDom.setLastLogin(now);
		return userDom;
	}
	
	public MasterDom createMasterDom(MasterDto masterDto) {
		MasterDom masterDom = new MasterDom();
		masterDom.setUser(createUserDom(masterDto.getUser()));
		masterDom.setDescription(masterDto.getDescription());
		masterDom.setRating(masterDto.getRating());
		return masterDom;
	}
}
