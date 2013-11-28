package cn.edu.bjut.help.account.service;

import cn.edu.bjut.help.core.bo.User;

public interface UserService {

	User findUserByUsername(String username);

	Long save(User user);

	//void addUserFromPassport(Long uid, String username);
}
