package main.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.classes.User;
import main.services.UserService;

@Controller
public class UserControler {
	@Autowired
	UserService userService;
@GetMapping("")
public String welcome(Model m)
{
	List<User> users=userService.findAll();
	User user=new User();
	m.addAttribute("user", user);
	m.addAttribute("users", users);
return "index.html";	
}
@GetMapping("age")
public String agefilter(Model m)
{
	List<User> users=userService.findOrder();
	User user=new User();
	m.addAttribute("user", user);
	m.addAttribute("users", users);
return "index.html";	
}
@PostMapping("add")
public String CreateUser(@ModelAttribute(name = "user") User user)
{
	userService.create(user);
	return "redirect:/";
}
@RequestMapping(value = "delete/{id}", method ={RequestMethod.GET, RequestMethod.DELETE})
public String supression(@PathVariable long id)
{
userService.deleteUser(id);
return "redirect:/";
}
}
