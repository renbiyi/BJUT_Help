package cn.edu.bjut.help.information.web.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.bjut.help.account.service.UserService;
import cn.edu.bjut.help.core.bo.Message;
import cn.edu.bjut.help.core.web.action.BaseAction;
import cn.edu.bjut.help.information.service.MessageService;

@Controller  
@RequestMapping("message")
public class MessageAction extends BaseAction {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "save/audio", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveAudioMessage() throws IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		MultipartFile file = req.getFile("audio");
	
//		String path = req.getContextPath()+"/audio/"+file.getOriginalFilename();
		String path = "E:/project/BJUT_Help/audio/"+file.getOriginalFilename();
		System.out.println(path);
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String theme = "null";
		String content = path;
		String contact = request.getParameter("contact");
		String expire = request.getParameter("expire");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		Date timestamp = new Date(System.currentTimeMillis());
		Long uid = userService.findUserByUsername(username).getId();
		String type = "1";
		
		if(file!=null && uid!=null && content!=null && content.length()!=0	&& contact!=null && contact.length()!=0
			&& expire!=null && expire.length()!=0 && longitude!=null && longitude.length()!=0
			&& longitude!=null && longitude.split("[.]")[0].length()<4 && latitude!=null && latitude.split("[.]")[0].length()<4	
		){
			Message mes = new Message();
			mes.setUserId(uid);
			mes.setContent(content);
			mes.setContact(contact);
			mes.setExpire(Long.parseLong(expire));
			mes.setLatitude(Double.parseDouble(latitude));
			mes.setLongitude(Double.parseDouble(longitude));
			mes.setType(Short.parseShort(type));
			mes.setTimestamp(timestamp);
			mes.setTheme(theme);
			messageService.saveMessage(mes);
			
			File output = new File(path);
			FileUtils.copyInputStreamToFile(file.getInputStream(), output);
			
			jsonMap.put("status", 1);
			jsonMap.put("data", "success");
		}else{
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
		}
		return jsonMap;
	}
	
	
	//http://localhost:8080/message/save/text?theme=21313&content=12312&contact=123123&expire=123123&longitude=1241&latitude=32542
	@RequestMapping(value = "save/text", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> saveTextMessage() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String theme = request.getParameter("theme");
		String content = request.getParameter("content");
		String contact = request.getParameter("contact");
		String expire = request.getParameter("expire");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		Date timestamp = new Date(System.currentTimeMillis());
		String type = "0";
		
		if(username!=null && username.length()!=0 && theme!=null && theme.length()!=0
			&& content!=null && content.length()!=0	&& contact!=null && contact.length()!=0
			&& expire!=null && expire.length()!=0 && longitude!=null && longitude.length()!=0
			&& longitude!=null && longitude.split("[.]")[0].length()<4 && latitude!=null && latitude.split("[.]")[0].length()<4){
			
			Long uid = userService.findUserByUsername(username).getId();
			Message mes = new Message();
			mes.setUserId(uid);
			mes.setContent(content);
			mes.setContact(contact);
			mes.setExpire(Long.parseLong(expire));
			mes.setLatitude(Double.parseDouble(latitude));
			mes.setLongitude(Double.parseDouble(longitude));
			mes.setType(Short.parseShort(type));
			mes.setTimestamp(timestamp);
			mes.setTheme(theme);
			messageService.saveMessage(mes);
			jsonMap.put("status", 1);
			jsonMap.put("data", "success");
		}else{
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
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
