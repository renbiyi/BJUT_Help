package cn.edu.bjut.help.information.web.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.bjut.help.account.service.UserService;
import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.core.web.action.BaseAction;
import cn.edu.bjut.help.information.service.MessageService;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;

@Controller  
@RequestMapping("message")
public class MessageAction extends BaseAction {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "save/audio", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveAudioMessage(@ModelAttribute MessageForm form) throws IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		MultipartFile file = req.getFile("audio");
		
		String path = "E:/project/BJUT_Help/audio/"+file.getOriginalFilename();
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String theme = "null";
		String content = path;
		Date timestamp = new Date();
		Short type = 1;
		int ret = 0;
		if(file!=null && username!=null){
			Long uid = userService.findUserByUsername(username).getId();
			form.setUid(uid);
			form.setTheme(theme);
			form.setContent(content);
			form.setType(type);
			form.setTimestamp(timestamp);
			ret = messageService.saveMessage(form);
			if(ret==1){
				File output = new File(path);
				FileUtils.copyInputStreamToFile(file.getInputStream(), output);
				jsonMap.put("status", 1);
				jsonMap.put("data", "success");
			}else{
				jsonMap.put("status", 0);
				jsonMap.put("data", "error");
			}
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
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Date timestamp = new Date();
		
		short type = 0;
		int ret = 0;
		if(username!=null){
			Long uid = userService.findUserByUsername(username).getId();
			form.setUid(uid);
			form.setType(type);
			form.setTimestamp(timestamp);
			ret = messageService.saveMessage(form);
			if(ret==1){
				jsonMap.put("status", ret);
				jsonMap.put("data", "success");
			}else{
				jsonMap.put("status", 0);
				jsonMap.put("data", "error");
			}
		}
		return jsonMap;
	}
	
	
	public static void main(String[] args){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date timestamp = new Date(System.currentTimeMillis());
		String dt = new String(dateFormat.format(timestamp));
		System.out.println(dt);
	}
	
}
