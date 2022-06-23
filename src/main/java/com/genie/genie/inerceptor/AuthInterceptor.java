package com.genie.genie.inerceptor;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genie.genie.dao.SessionDao;
import com.genie.genie.dao.dom.SessionDom;
import org.springframework.web.servlet.HandlerInterceptor;

import com.genie.genie.exception.AppException;
import com.genie.genie.exception.MessageEnum;
import com.genie.genie.utils.Constants;

public class AuthInterceptor implements HandlerInterceptor {

	@Resource
	private SessionDao sessionDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String url = request.getRequestURL().toString();
		// LOGGER.debug("Request is get with url: {}", url);
		
		if(url.equals("/hello") || url.equals("/user/login")) {
			return true;
		}
		String authToken = request.getHeader(Constants.AUTH_TOKEN);
		if (authToken == null) {
			throw new AppException(null, MessageEnum.AUTHENTICATION_FAILED);
		}
		
		SessionDom session = sessionDao.findByAuthToken(authToken);
		if (session == null) {
			throw new AppException(null, MessageEnum.AUTHENTICATION_FAILED);
		}
		
		Date now = new Date(System.currentTimeMillis());
	    long diffInMillies = now.getTime() - session.getLastLogin().getTime();
	    int diffInHours = (int) ((diffInMillies / (1000*60*60)) % 24);
	    if(diffInHours > Constants.TIME_OUT_IN_HOURS) {
	    	throw new AppException(MessageEnum.SESSION_EXPIRED);
	    }
	
		session.setLastLogin(new Date(System.currentTimeMillis()));
		sessionDao.save(session);
				
		return true;
	}

}
