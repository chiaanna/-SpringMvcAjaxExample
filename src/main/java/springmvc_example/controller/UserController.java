package springmvc_example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.User;
import springmvc_example.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
    
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView searchForm() {
		ModelAndView model = new ModelAndView("user/search");
		
		return model;
	}
	
	@RequestMapping(value="/search")
	public @ResponseBody List<User> ajaxSearch(HttpServletRequest req,HttpServletResponse res) {
		List<User> list = userService.listUserByName(req.getParameter("name"));
		
		return list;
	}
	
}
