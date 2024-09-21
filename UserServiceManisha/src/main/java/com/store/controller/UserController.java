package com.store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.UserDTO;
import com.store.entity.User;
import com.store.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public User createUser(@RequestBody User user) {

		User saveuser = userService.createUser(user);
		return saveuser;
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {

		User updateuser = userService.updateUser(user);
		return updateuser;

	}

	@DeleteMapping("/delete/{id}")
	public String deletestudent(@PathVariable Long id) {

		userService.deleteUser(id);
		return "delete";
	}

	@GetMapping("/{ownerid}")
	public UserDTO GetAadharData(@PathVariable("ownerid") Long ownerid) {
		return userService.GetUserData(ownerid);
	}
	

}
