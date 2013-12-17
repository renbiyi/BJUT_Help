package cn.edu.bjut.help.information.web.action;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.bjut.help.core.excep.ServiceException;
import cn.edu.bjut.help.core.web.action.BaseAction;
import cn.edu.bjut.help.information.service.MessageService;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;
import cn.edu.bjut.help.information.web.action.dto.MessageVO;

@Controller  
@RequestMapping("message")
public class MessageAction extends BaseAction {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "save/audio", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveAudioMessage(@ModelAttribute MessageForm form) throws IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		MultipartFile audioFile = req.getFile("audio");
		
		if (messageService.createAudioMessage(form, audioFile, getVisitor())){
			jsonMap.put("status", 1);
			jsonMap.put("data", "success");
		}else{
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
		}
		
		return jsonMap;
	}
	
	
	//http://localhost:8080/message/save/text?theme=21313&content=12312&contact=123123&expire=12&longitude=12&latitude=3
	@RequestMapping(value = "save/text", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveTextMessage(@ModelAttribute MessageForm form) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		if (messageService.createTextMessage(form, getVisitor())) {
			jsonMap.put("status", 1);
			jsonMap.put("data", "success");
		} else {
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value = "list/{longitude}/{latitude}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listMessages(@PathVariable Double longitude, @PathVariable Double latitude) throws IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<MessageVO> messageVOs = null;
		try {
			messageVOs = messageService.listMessagesByPosition(longitude, latitude);
		} catch (ServiceException e) {
			logger.warn("", e);
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
			return jsonMap;
		}
		
		jsonMap.put("status", 1);
		jsonMap.put("data", messageVOs);
		return jsonMap;
	}
	
	
}
