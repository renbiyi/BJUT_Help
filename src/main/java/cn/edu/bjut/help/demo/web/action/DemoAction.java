package cn.edu.bjut.help.demo.web.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.bjut.help.core.web.action.BaseAction;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;

@Controller
@RequestMapping("demo")
public class DemoAction extends BaseAction {

	@RequestMapping(value = "hellojson", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> hellojson() {

		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		logger.info("current user is " + username);

		// SecurityContext sctx = (SecurityContext)
		// session.getAttribute("SPRING_SECURITY_CONTEXT");
		// logger.info("current user[session get] is " +
		// sctx.getAuthentication().getName());

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("status", 200);
		jsonMap.put("data", "zhanghao");

		return jsonMap;
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> handleAnotherUploadProcess() throws Exception {
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		MultipartFile file = req.getFile("imageFile");
		File output = new File("/Users/zhanghao/" + file.getOriginalFilename());
		FileUtils.copyInputStreamToFile(file.getInputStream(), output);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("status", 200);
		jsonMap.put("data", "upload sucessful");
		
		return jsonMap;
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> test(@ModelAttribute MessageForm form) throws Exception {
		logger.info(form.getContact());
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("status", 200);
		jsonMap.put("data", "upload sucessful");
		
		return jsonMap;
	}
	
}
