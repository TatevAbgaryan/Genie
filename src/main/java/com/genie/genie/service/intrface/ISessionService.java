package com.genie.genie.service.intrface;

import com.genie.genie.dto.SessionDto;
import com.genie.genie.dto.UserDto;

public interface ISessionService {

    public SessionDto login(UserDto user);
}
