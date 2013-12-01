package cn.edu.bjut.help.core.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseAction {

	protected Logger logger = Logger.getLogger(getClass());
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(true);
	}
}
