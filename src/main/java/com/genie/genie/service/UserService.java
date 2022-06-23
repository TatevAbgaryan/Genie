package com.genie.genie.service;

import com.genie.genie.dao.MasterDao;
import com.genie.genie.dao.UserDao;
import com.genie.genie.dao.dom.MasterDom;
import com.genie.genie.dao.dom.UserDom;
import com.genie.genie.dto.MasterDto;
import com.genie.genie.dto.UserDto;
import com.genie.genie.service.intrface.IUserService;
import com.genie.genie.helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MasterDao masterDao;
	
	@Autowired
	private UserHelper userHelper;

	public UserDto getUser(String username, String password) {
		UserDom user = userDao.findByUsernameAndPassword(username, password);
		
		return new UserDto(user);
	}

	public UserDto getUser(String username){
		UserDom user = userDao.findByUsername(username);

		return new UserDto(user);
	}

	public UserDto registerAsUser(UserDto userDto){
		userHelper.validateUserRegistration(userDto);		
		UserDom user = userDao.save(userHelper.createUserDom(userDto));
		userDto.setId(user.getId());
		
		return userDto;		
	}

	@Override
	public MasterDto registerAsMaster(MasterDto masterDto) {
		MasterDom master = masterDao.save(userHelper.createMasterDom(masterDto));
		masterDto.setId(master.getId());
		return masterDto;
	}
}
