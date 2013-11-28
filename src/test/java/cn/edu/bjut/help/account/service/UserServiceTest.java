package cn.edu.bjut.help.account.service;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.bjut.help.core.bo.User;
import cn.edu.bjut.help.test.util.SpringTransactionalTestCase;

public class UserServiceTest extends SpringTransactionalTestCase {

	private static Logger log = Logger.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void itShouldFindUser() {
		String username = "zhanghao";
		User user = userService.findUserByUsername(username);
		log.info(user.getId());
		Assert.assertThat(user, Matchers.notNullValue());
	}
	
}
