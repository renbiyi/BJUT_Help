package cn.edu.bjut.help.information.service;

import org.springframework.stereotype.Service;

import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;

@Service
public interface MessageService {
	int saveMessage(MessageForm msg);
}
