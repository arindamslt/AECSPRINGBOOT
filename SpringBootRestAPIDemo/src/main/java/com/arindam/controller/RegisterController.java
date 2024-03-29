package com.arindam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.model.Registration;
import com.arindam.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
RegisterService rservice;
	@Autowired
	Environment env;
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Registration reg)
	{
		rservice.addData(reg);
		String msg=env.getProperty("register.add.data");
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/fetch")
	public ResponseEntity<List<Registration>> getData()
	{
		List<Registration> rlist=rservice.getData();
		return new ResponseEntity<List<Registration>>(rlist,HttpStatus.OK);
	}
	@GetMapping("/fetch/{uname}")
	public ResponseEntity<Registration> getDataByUname(@PathVariable String uname)
	{
		Registration reg=rservice.getDataByUname(uname);
		return new ResponseEntity<Registration>(reg,HttpStatus.OK);
	}
	@DeleteMapping("/del/{uname}")
	public ResponseEntity<String> deleteData(@PathVariable String uname)
	{
		rservice.deleteData(uname);
		String msg=env.getProperty("reg.data.delete");
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/upd/{uname}")
	public ResponseEntity<Registration> updateData(@PathVariable String uname,@RequestBody Registration reg)
	{
		Registration regs=rservice.updateData(uname, reg);
		return new ResponseEntity<Registration>(regs,HttpStatus.OK);
		
	}
}
