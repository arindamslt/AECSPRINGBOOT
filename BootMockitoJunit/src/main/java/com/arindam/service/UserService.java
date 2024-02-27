package com.arindam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.model.User;
import com.arindam.repository.UserRepository;

@Service
public class UserService {
	@Autowired
private UserRepository urepo;
public User addData(User user)
{
	User usr=urepo.save(user);
	return usr;
}
public List<User> getData()
{
	List<User> ulist=urepo.findAll();
	System.out.println("GETTING DATA FROM DB:"+ulist);
	return ulist;
}
public User getbyId(Integer id)
{
	User usr=urepo.findById(id).orElse(null);
	return usr;
}
public void deleteData(User user)
{
	urepo.delete(user);
}
}
