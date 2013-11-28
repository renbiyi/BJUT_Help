package cn.edu.bjut.help.core.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.edu.bjut.help.account.service.RoleService;
import cn.edu.bjut.help.account.service.UserService;
import cn.edu.bjut.help.core.bo.Role;
import cn.edu.bjut.help.core.bo.User;

public class UserDetailServiceImpl implements UserDetailsService {

	private static Logger log = Logger.getLogger(UserDetailsService.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		if (log.isDebugEnabled()) {
			log.debug("username is " + username);
		}

		User user = userService.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);  
        
        boolean enables = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;
        String password = user.getPassword();
        
        return new org.springframework.security.core.userdetails.User(username, password, enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);  
	}
	
	//取得用户的权限  
    private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {  
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>(); 
        List<Role> roles = roleService.findRolesByUser(user);
          
        for(Role role : roles) {
        	authSet.add(new SimpleGrantedAuthority(role.getName()));  
        }
        
        return authSet;  
    }

}
