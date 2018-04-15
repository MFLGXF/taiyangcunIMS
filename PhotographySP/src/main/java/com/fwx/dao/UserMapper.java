package com.fwx.dao;

import java.util.List;

import com.fwx.domain.User;

public interface UserMapper {

	public List<User> login(User user);

}
