package cn.edu.bjut.help.core.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private String defaultTargetUrl;
	
	@Override
	public void commence(final HttpServletRequest request,
			final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {

        // Set the 403 status code.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        request.getRequestDispatcher(defaultTargetUrl).forward(request, response);
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}
	

}
