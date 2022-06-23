package com.genie.genie.dao;

import com.genie.genie.dao.dom.UserDom;

public interface UserDao extends BaseDao<UserDom> {

	UserDom findByUsername(String username);
	
	UserDom findByEmail(String email);

	UserDom findByUsernameAndPassword(String username, String password);

}
