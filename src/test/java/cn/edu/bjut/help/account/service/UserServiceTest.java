package cn.edu.bjut.help.account.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import cn.edu.bjut.help.account.dao.UserDao;
import cn.edu.bjut.help.account.service.impl.UserServiceImpl;
import cn.edu.bjut.help.core.bo.User;
import cn.edu.bjut.help.test.util.UnitTestCase;

public class UserServiceTest extends UnitTestCase {

	private UserService userService;
	
	@Override
	public void setUp() {
		userService = new UserServiceImpl();
	}
	
	@Test
	public void itShouldFindUser() {
		// [Given]
		String username = "zhanghao";
		User givenUser = new User();
		givenUser.setId(1L);
		givenUser.setUsername(username);
		
		// [When]
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userService, "userDao", userDao);
		Mockito.when(userDao.findUserByUsername(username)).thenReturn(givenUser);
		User user = userService.findUserByUsername(username);
		
		// [Then]
		Assert.assertThat(user, Matchers.notNullValue());
	}
	
}
