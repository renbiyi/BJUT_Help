package cn.edu.bjut.help.account.service;

import java.util.List;

import cn.edu.bjut.help.core.bo.Role;
import cn.edu.bjut.help.core.bo.User;

public interface RoleService {

	List<Role> findRolesByUser(User user);
	
	Role findRoleByName(String roleName);

	void addRole4User(String roleName, User user);
}
