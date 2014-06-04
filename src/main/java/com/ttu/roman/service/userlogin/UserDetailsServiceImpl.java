package com.ttu.roman.service.userlogin;

import com.ttu.roman.dao.userlogin.UserAccountDAO;
import com.ttu.roman.model.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserAccountDAO userAccountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount userAccount = userAccountService.findByUserName(username);
		
		if (userAccount == null) {
			throw new UsernameNotFoundException("Not found");
		}
		
		return new UserPrincipal(userAccount);
	}
}