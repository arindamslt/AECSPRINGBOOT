package com.arindam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.model.User;
import com.arindam.service.UserService;

@RestController
@RequestMapping("/use")
public class UserController {
	@Autowired
private UserService uservice;

@PostMapping("/add")
public User addData(@RequestBody User user)
{
	
	return uservice.addData(user);
	
}
@GetMapping("/fetch")
public List<User> getData()
{
	return uservice.getData();
	
}
@GetMapping("/fetch/{id}")
public User getById(@PathVariable Integer id)
{
	return uservice.getbyId(id);
	
}
@DeleteMapping("/del")
public void deleteData(@RequestBody User user)
{
	uservice.deleteData(user);
   
}
}
