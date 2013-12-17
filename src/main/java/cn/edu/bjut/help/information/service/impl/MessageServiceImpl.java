package cn.edu.bjut.help.information.service.impl;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.core.config.SystemConfig;
import cn.edu.bjut.help.core.cons.MessageType;
import cn.edu.bjut.help.core.web.action.dto.Visitor;
import cn.edu.bjut.help.information.dao.MessageDao;
import cn.edu.bjut.help.information.service.MessageService;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;
import cn.edu.bjut.help.util.RandomNumberGenernator;

@Service
public class MessageServiceImpl implements MessageService {

	private Logger logger = Logger.getLogger(MessageService.class);
	
	@Autowired
	private MessageDao msgDao;
	@Autowired
	private SystemConfig config;
	
	@Override
	public boolean createTextMessage(MessageForm msgForm, Visitor visitor) {
		
		if (StringUtils.isBlank(msgForm.getContent())) {
			return Boolean.FALSE;
		}
		
		return createMessage(msgForm, visitor, MessageType.TEXT);
	}
	
	@Override
	public boolean createAudioMessage(MessageForm msgForm, MultipartFile file, Visitor visitor) {
		
		if (ObjectUtils.equals(file, null)) {
			return Boolean.FALSE;
		}
		
		StringBuilder filename = new StringBuilder();
		filename.append(RandomNumberGenernator.next());
		filename.append(".");
		filename.append(StringUtils.substringAfterLast(file.getOriginalFilename(), "."));
		StringBuilder outputPath = new StringBuilder();
		outputPath.append(config.getAuidoDirectoryPath()).append(filename);
		File outputFile = new File(outputPath.toString());
		
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), outputFile);
		} catch (IOException e) {
			logger.info("", e);
		}
		
		msgForm.setContent("/audio/" + filename);
		return createMessage(msgForm, visitor, MessageType.AUDIO);
	}

	private boolean createMessage(MessageForm msgForm, Visitor visitor, MessageType type) {
//		int ret = 0;
//		if(msg.getUid()!=null  
//			&& msg.getContact()!=null && msg.getContact().length()!=0
//			&& msg.getExpire()!=null && msg.getLongitude()!=null
//			&& msg.getLatitude()!=null){
//			msgDao.saveMessage(msg.createMessage());
//			ret = 1;
//		}else{
//			ret = 0;
//		}
		
		if (!validateMessageForm(msgForm)) {
			return Boolean.FALSE;
		}
		
		Message msg = msgForm.createMessage();
		
		msg.setUserId(visitor.getId());
		msg.setType(type.getValue());
		msg.setTimestamp(new Date());
		
		msgDao.saveMessage(msg);
		return Boolean.TRUE;
	}
	
	private boolean validateMessageForm(MessageForm form) {
		return (StringUtils.isNotBlank(form.getTheme())
				&& StringUtils.isNotBlank(form.getContact())
				&& ObjectUtils.notEqual(form.getExpire(), null)
				&& ObjectUtils.notEqual(form.getLatitude(), null) && ObjectUtils
					.notEqual(form.getLongitude(), null));
	}
}
