package cn.edu.bjut.help.core.auth.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjut.help.core.web.action.BaseAction;

@Controller  
@RequestMapping("")
public class RestAuthenticationAction extends BaseAction {

	@RequestMapping(value = "authenticationFailure", method = RequestMethod.POST) 
	@ResponseBody
    public Map<String, Object> authenticationFailure() {
		
		AuthenticationException exception = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("httpcode", HttpServletResponse.SC_BAD_REQUEST);
		jsonMap.put("message", exception.getMessage());
		
        return jsonMap;
    }
	
	@RequestMapping(value = "authenticationSuccess", method = RequestMethod.POST) 
	@ResponseBody
    public Map<String, Object> authenticationSuccess() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("httpcode", HttpServletResponse.SC_OK);
		jsonMap.put("message", "Authentication success");
		
        return jsonMap;
    }
	
	@RequestMapping(value = "logoutSuccess", method = RequestMethod.GET) 
	@ResponseBody
    public Map<String, Object> logoutSuccess() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("httpcode", HttpServletResponse.SC_OK);
		jsonMap.put("message", "Logout success");
		
        return jsonMap;
    }
	
	@RequestMapping(value = "unauthorized") 
	@ResponseBody
    public Map<String, Object> unauthorized() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("httpcode", HttpServletResponse.SC_UNAUTHORIZED);
		jsonMap.put("message", "Unauthorized");
		
		return jsonMap;
	}
	
	@RequestMapping(value = "accessDenied", method = RequestMethod.GET) 
	@ResponseBody
    public Map<String, Object> accessDenied() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("httpcode", HttpServletResponse.SC_FORBIDDEN);
		jsonMap.put("message", "AccessDenied");
		
		return jsonMap;
	}
	
	
	
	

}
