package cn.edu.bjut.help.information.service;

import org.springframework.stereotype.Service;
import cn.edu.bjut.help.core.bo.Message;

@Service
public interface MessageService {
	int saveMessage(Message msg);
}
