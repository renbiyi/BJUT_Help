package cn.edu.bjut.help.information.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.information.dao.MessageDao;
import cn.edu.bjut.help.information.service.MessageService;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao msgDao;

	@Override
	public int saveMessage(MessageForm msg) {
		int ret = 0;
		if(msg.getUid()!=null  
			&& msg.getContact()!=null && msg.getContact().length()!=0
			&& msg.getExpire()!=null && msg.getLongitude()!=null
			&& msg.getLatitude()!=null){
			msgDao.saveMessage(msg.createMessage());
			ret = 1;
		}else{
			ret = 0;
		}
		return ret;
	}
}
