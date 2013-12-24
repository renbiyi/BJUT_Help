package cn.edu.bjut.help.information.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.core.cons.MessageType;
import cn.edu.bjut.help.core.excep.ServiceException;
import cn.edu.bjut.help.core.web.action.dto.Visitor;
import cn.edu.bjut.help.information.dao.MessageDao;
import cn.edu.bjut.help.information.service.impl.MessageServiceImpl;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;
import cn.edu.bjut.help.test.util.UnitTestCase;


public class MessageServiceTest extends UnitTestCase {

	private MessageService messageService;
	
	@Override
	public void setUp() {
		messageService = new MessageServiceImpl();
	}
	
	@Test
	public void itShouldCreateTextMessageFailedCausedByContentIsBlank() {
		// [Given]
		MessageForm msgForm = new MessageForm();
		msgForm.setTheme("just test");
		msgForm.setContact("hello");
		msgForm.setExpire(12L);
		msgForm.setLatitude(12.87);
		msgForm.setLongitude(67.98);
		msgForm.setPosition("zzzz");
		
		Visitor visitor = new Visitor();
		visitor.setId(1L);
		visitor.setUsername("zhanghao");
		
		// [When]
		boolean result = messageService.createTextMessage(msgForm, visitor);
		
		// [Then]
		Assert.assertThat(result, Matchers.equalTo(Boolean.FALSE));
	}
	
	@Test
	public void itShouldCreateMessageSuccessfully() {
		// [Given]
		MessageForm msgForm = new MessageForm();
		msgForm.setTheme("just test");
		msgForm.setContact("hello");
		msgForm.setExpire(12L);
		msgForm.setLatitude(12.87);
		msgForm.setLongitude(67.98);
		msgForm.setPosition("zzzz");
		
		Visitor visitor = new Visitor();
		visitor.setId(1L);
		visitor.setUsername("zhanghao");
		
		MessageType type = MessageType.TEXT;
		
		// [When]
		MessageDao messageDao = mock(MessageDao.class);
		ReflectionTestUtils.setField(messageService, "messageDao", messageDao);
		when(messageDao.saveMessage(any(Message.class))).thenReturn(1);
		boolean result = (Boolean) ReflectionTestUtils.invokeMethod(messageService, "createMessage", msgForm, visitor, type);
		
		// [Then]
		Assert.assertThat(result, Matchers.equalTo(Boolean.TRUE));
	}
	
	@Test
	public void itShouldCreateMessageFailedCausedByInvalidatedMessageForm() {
		// [Given]
		MessageForm msgForm = new MessageForm();
		msgForm.setTheme("just test");
		
		Visitor visitor = new Visitor();
		visitor.setId(1L);
		visitor.setUsername("zhanghao");
		
		MessageType type = MessageType.TEXT;
		
		// [When]
		MessageDao messageDao = mock(MessageDao.class);
		ReflectionTestUtils.setField(messageService, "messageDao", messageDao);
		when(messageDao.saveMessage(any(Message.class))).thenReturn(1);
		boolean result = (Boolean) ReflectionTestUtils.invokeMethod(messageService, "createMessage", msgForm, visitor, type);
		
		// [Then]
		Assert.assertThat(result, Matchers.equalTo(Boolean.FALSE));
	}
	
	@Test(expected = ServiceException.class)
	public void itShouldListMessagesFailedCausedByLongitudeOrlatitudeIsNull() throws ServiceException {
		// [Given]
		Double longitude = null;
		Double latitude = null;
		
		// [When]
		messageService.listMessagesByPosition(longitude, latitude);
		
		// [Then]
	}
}
