package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.User;

public interface UserDao {
   
	public List<User> listUserByName(String name);
}
