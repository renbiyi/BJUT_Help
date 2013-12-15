package cn.edu.bjut.help.information.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.information.dao.MessageDao;
import cn.edu.bjut.help.information.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao msgDao;

	@Override
	public int saveMessage(Message msg) {
		
		return msgDao.saveMessage(msg);
	}

}
