package xyz.sporty_shoes.config.dao;


import org.springframework.security.core.userdetails.UserDetailsService;

import xyz.sporty_shoes.config.entity.User;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
