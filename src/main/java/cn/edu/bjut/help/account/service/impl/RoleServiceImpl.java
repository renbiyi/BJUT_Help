package cn.edu.bjut.help.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import cn.edu.bjut.help.account.dao.RoleDao;
import cn.edu.bjut.help.account.dao.UserRoleDao;
import cn.edu.bjut.help.account.service.RoleService;
import cn.edu.bjut.help.core.bo.Role;
import cn.edu.bjut.help.core.bo.User;
import cn.edu.bjut.help.core.bo.UserRole;

@Component("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public List<Role> findRolesByUser(User user) {
		Assert.notNull(user.getId(), "userId can't be null.");
		return roleDao.findRolesByUserId(user.getId());
	}

	@Override
	public void addRole4User(String roleName, User user) {
		Assert.notNull(user.getId(), "userId can't be null.");
		Assert.notNull(roleName, "roleName can't be null.");
		
		Role role = this.findRoleByName(roleName);
		
		Assert.notNull(role, "roleName=" + roleName + " can't be null.");
		
		Long userId = user.getId();
		Long roleId = role.getId();
		
		UserRole userRole = new UserRole();
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);
		userRoleDao.save(userRole);
		
		return;
	}

	@Override
	public Role findRoleByName(String roleName) {
		Assert.notNull(roleName, "roleName can't be null.");
		return roleDao.findRoleByName(roleName);
	}

}
