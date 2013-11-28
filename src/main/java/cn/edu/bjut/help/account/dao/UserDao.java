package cn.edu.bjut.help.account.dao;

import cn.edu.bjut.help.core.bo.User;

public interface UserDao {

	User findUserByUsername(String username);

	void save(User user);

	void update(User user);

}
