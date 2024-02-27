package com.arindam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.model.Registration;
import com.arindam.repository.RegisterRepository;

@Service
public class RegisterService {
	@Autowired
private RegisterRepository rrepo;
	
	public void addData(Registration registration)
	{
		rrepo.save(registration);
	}
	public List<Registration> getData()
	{
		List<Registration> rlist=rrepo.findAll();
		return rlist;
	}
	public Registration checkLogin(String uname,String pass)
	{
		Registration registration=rrepo.checkLogin(uname, pass);
		return registration;
	}
}