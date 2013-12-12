package cn.edu.bjut.help.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjut.help.core.web.action.BaseAction;

@Controller  
@RequestMapping("demo")
public class DemoAction extends BaseAction {

	@RequestMapping(value = "hellojson", method = RequestMethod.GET) 
	@ResponseBody
    public Map<String, Object> hellojson() {  
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("current user is " + username);
		
//		SecurityContext sctx = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
//		logger.info("current user[session get] is " + sctx.getAuthentication().getName());
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("status", 200);
		jsonMap.put("data", "zhanghao");
		
        return jsonMap;
    }
}
