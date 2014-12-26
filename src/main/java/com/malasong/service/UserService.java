package com.malasong.service;

import java.util.List;

import com.demo2do.core.service.GenericService;
import com.malasong.entity.Clazz;
import com.malasong.entity.User;

public interface UserService extends GenericService<User> {

	public List<User> list();

	public void create(User user);

	public void edit(User user, String name, int year, Clazz clazz);

}
