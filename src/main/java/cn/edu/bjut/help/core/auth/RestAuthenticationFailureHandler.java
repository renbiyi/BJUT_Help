package cn.edu.bjut.help.core.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private String defaultFailureUrl;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
        if (defaultFailureUrl == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
        } else {
        	response.setStatus(HttpServletResponse.SC_OK);
            saveException(request, exception);
            request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
        }
		
	}
	
	protected final void saveException(HttpServletRequest request,
			AuthenticationException exception) {
		HttpSession session = request.getSession(true);

		if (session != null) {
			request.getSession().setAttribute(
					WebAttributes.AUTHENTICATION_EXCEPTION, exception);
		}
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}
	
}
