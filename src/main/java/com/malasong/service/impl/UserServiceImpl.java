package com.malasong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2do.core.persistence.GenericDaoSupport;
import com.demo2do.core.service.impl.GenericServiceImpl;
import com.malasong.entity.User;
import com.malasong.service.UserService;

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User>  implements UserService {

	@Autowired
	private GenericDaoSupport genericDaoSupport;

	public List<User> list() {
		return genericDaoSupport.loadAll(User.class);
	}

}
