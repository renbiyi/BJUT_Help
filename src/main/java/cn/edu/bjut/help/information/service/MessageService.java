package cn.edu.bjut.help.information.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjut.help.core.web.action.dto.Visitor;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;

@Service
public interface MessageService {
	boolean createTextMessage(MessageForm msg, Visitor visitor);
	boolean createAudioMessage(MessageForm msg, MultipartFile file, Visitor visitor);
}
