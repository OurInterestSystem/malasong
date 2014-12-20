package com.malasong.service;

import java.util.List;

import com.malasong.entity.User;

public interface UserService {

	public List<User> list();

	public void create(User user);
}
