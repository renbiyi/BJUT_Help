package cn.edu.bjut.help.information.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjut.help.core.excep.ServiceException;
import cn.edu.bjut.help.core.web.action.dto.Visitor;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;
import cn.edu.bjut.help.information.web.action.dto.MessageVO;

public interface MessageService {
	boolean createTextMessage(MessageForm msg, Visitor visitor);
	boolean createAudioMessage(MessageForm msg, MultipartFile file, Visitor visitor);
	List<MessageVO> listMessagesByPosition(Double longitude, Double latitude) throws ServiceException;
}
