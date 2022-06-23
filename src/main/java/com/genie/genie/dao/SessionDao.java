package com.genie.genie.dao;

import com.genie.genie.dao.dom.SessionDom;

public interface SessionDao extends BaseDao<SessionDom>{

	public SessionDom findByAuthToken(String authToken);

	public SessionDom findByUserId(int userId);
	
	public void deleteByUserId(int userId);
	
}
