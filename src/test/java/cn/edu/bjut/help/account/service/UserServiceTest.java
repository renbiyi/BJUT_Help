package cn.edu.bjut.help.account.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import cn.edu.bjut.help.core.bo.User;
import cn.edu.bjut.help.test.util.UnitTestCase;

public class UserServiceTest extends UnitTestCase {

	@Mock
	private UserService userService;
	
	@Test
	public void itShouldFindUser() {
		// [Given]
		String username = "zhanghao";
		User givenUser = new User();
		givenUser.setId(1L);
		givenUser.setUsername(username);
		
		// [When]
		Mockito.when(userService.findUserByUsername(username)).thenReturn(givenUser);
		User user = userService.findUserByUsername(username);
		
		// [Then]
		Assert.assertThat(user, Matchers.notNullValue());
	}
	
}
