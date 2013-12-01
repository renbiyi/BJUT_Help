package cn.edu.bjut.help.core.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private Logger logger = Logger.getLogger(getClass());
	
	private String defaultTargetUrl;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
        request.getRequestDispatcher(defaultTargetUrl).forward(request, response);
		logger.info(authentication.getName());
        
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

	
}
