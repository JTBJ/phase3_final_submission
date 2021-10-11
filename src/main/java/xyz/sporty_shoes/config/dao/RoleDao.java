package xyz.sporty_shoes.config.dao;

import xyz.sporty_shoes.config.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
