package com.genie.genie.service.intrface;

import com.genie.genie.dto.MasterDto;
import com.genie.genie.dto.UserDto;

public interface IUserService {

	public UserDto getUser(String username, String password);

	public UserDto getUser(String username);

	public UserDto registerAsUser(UserDto userDto);
	
	public MasterDto registerAsMaster(MasterDto masterDto);

}
