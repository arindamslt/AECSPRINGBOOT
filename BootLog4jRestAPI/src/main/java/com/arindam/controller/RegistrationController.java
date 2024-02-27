package com.arindam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.model.Registration;
import com.arindam.service.RegisterService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins="http://localhost:3000/")
public class RegistrationController {
	@Autowired
private RegisterService rservice;
	@Autowired
Environment env;
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Registration registration)
	{
		String msg=env.getProperty("register.add.data");
		rservice.addData(registration);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/fetch")
	public ResponseEntity<List<Registration>> getData()
	{
		List<Registration> rlist=rservice.getData();
		return new ResponseEntity<List<Registration>>(rlist,HttpStatus.OK);
	}
	
	@GetMapping("/login/{uname}/{pass}")
		public ResponseEntity<Registration> checkLogin(@PathVariable String uname,@PathVariable String pass)
	{
	    Registration registration=rservice.checkLogin(uname, pass);
	    return new ResponseEntity<Registration>(registration,HttpStatus.OK);
	}
}
