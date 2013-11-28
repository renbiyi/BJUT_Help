package cn.edu.bjut.help.core.auth;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import cn.edu.bjut.help.account.service.ResourceService;
import cn.edu.bjut.help.core.bo.Resource;

public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private static Logger log = Logger.getLogger(SecurityMetadataSource.class);
	
	private Map<String, Collection<ConfigAttribute>> resourceMap = null; 
	
	@Autowired
	private ResourceService resourceService;
	
	@PostConstruct
	private void init() {
		loadResourceDefine();
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		String requestUrl = request.getRequestURI();
		
		if (log.isDebugEnabled()) {
			log.debug("requestUrl is " + requestUrl);
		}
		
		Iterator<String> iter = resourceMap.keySet().iterator();
		while (iter.hasNext()) {
			String url = iter.next();
			
			RequestMatcher matcher = new AntPathRequestMatcher(url);
			if (matcher.matches(request)) {
				return resourceMap.get(url);
			}
		}
		
		return null;
	}

	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		List<Resource> resources = resourceService.findAllResources();

		for (Resource resource : resources) {
			List<ConfigAttribute> configAttributes = SecurityConfig
					.createListFromCommaDelimitedString(resource.getAuth());
			resourceMap.put(resource.getUrl(), configAttributes);
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		List<ConfigAttribute> allcConfigAttributes = new LinkedList<ConfigAttribute>();
		
		List<Resource> resources = resourceService.findAllResources();
		for (Resource resource : resources) {
			List<ConfigAttribute> configAttributes = SecurityConfig
					.createListFromCommaDelimitedString(resource.getAuth());
			allcConfigAttributes.addAll(configAttributes);
		}
		
		return allcConfigAttributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
