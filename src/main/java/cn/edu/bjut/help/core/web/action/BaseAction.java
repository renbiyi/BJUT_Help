package cn.edu.bjut.help.core.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.edu.bjut.help.account.service.UserService;
import cn.edu.bjut.help.core.bo.User;
import cn.edu.bjut.help.core.web.action.dto.Visitor;

public class BaseAction {

	protected Logger logger = Logger.getLogger(getClass());
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(true);
	}
	
	protected Visitor getVisitor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Visitor visitor = null;
		
		if (authentication.isAuthenticated()) {
			String username = authentication.getName();
			User user = userService.findUserByUsername(username);
			
			visitor = new Visitor();
			visitor.setId(user.getId());
			visitor.setUsername(user.getUsername());
		}
		
		return visitor;
	}
}
