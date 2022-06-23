package com.genie.genie.service;

import com.genie.genie.dao.SessionDao;
import com.genie.genie.dao.dom.SessionDom;
import com.genie.genie.dto.SessionDto;
import com.genie.genie.dto.UserDto;
import com.genie.genie.exception.AppException;
import com.genie.genie.exception.MessageEnum;
import com.genie.genie.helper.SessionHelper;
import com.genie.genie.service.intrface.ISessionService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SessionService implements ISessionService {

    @Resource
    private SessionHelper sessionHelper;

    @Resource
    private SessionDao sessionDao;

    @Resource
    private UserService userService;

    @Override
    public SessionDto login(UserDto user) {
        user = userService.getUser(user.getUsername(), user.getPassword());

        if(user == null) {
            throw new AppException(MessageEnum.LOGIN_FAILED);
        }
        SessionDom session = sessionDao.findByUserId(user.getId());
        SessionDto sessionDto;
        if(session == null){
            sessionDto = createSession(user);
        }else{
            sessionDto = updateSession(session);
        }
        return sessionDto;
    }

    public SessionDto createSession(UserDto user) {
        SessionDom session = new SessionDom();
        session.setUser(userService.getUser(user.getUsername()).getUserDom());
        session.setAuthToken(sessionHelper.generateNewToken());
        session.setLastLogin(new Date(System.currentTimeMillis()));

        sessionDao.save(session);
        return sessionHelper.createSessionDto(session);
    }
    public SessionDto updateSession(SessionDom session) {
        session.setLastLogin(new Date(System.currentTimeMillis()));

        sessionDao.save(session);
        return sessionHelper.createSessionDto(session);
    }
}
