package springmvc_example.service;

import java.util.List;

import springmvc_example.model.User;

public interface UserService{
    
	public List<User> listUserByName(String name);
	
}
