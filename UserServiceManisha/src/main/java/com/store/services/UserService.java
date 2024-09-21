package com.store.services;

import java.util.List;

import com.store.dto.UserDTO;
import com.store.entity.User;

public interface UserService {
	
	
    public User createUser(User user);
    public User updateUser(User user);
    public String deleteUser(Long id);
    public UserDTO GetUserData(Long ownerid);
    

}
