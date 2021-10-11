package xyz.sporty_shoes.config.dao;

import java.util.List;

import xyz.sporty_shoes.config.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
        
}
