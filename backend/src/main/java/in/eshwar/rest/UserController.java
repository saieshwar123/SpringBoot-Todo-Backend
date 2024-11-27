package in.eshwar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.eshwar.details.User;
import in.eshwar.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from your React frontend

public class UserController {
	
	@Autowired
	private UserRepository user;
	
	@PostMapping("/user/postData")
	public User postUser(@RequestBody User u) {
		System.out.println(u);
		user.save(u);
		return u;
	}
	
	@PostMapping("/user/login/{email}/{password}")
	public User loginUser(@PathVariable String email,@PathVariable String password)
	{
	User byEmailAndPassword = user.findByEmailAndPassword(email, password);
	return byEmailAndPassword;
	}

}
