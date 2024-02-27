package com.arindam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.model.Registration;
import com.arindam.rrepository.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
RegisterRepo rrepo;
	public void addData(Registration reg)
	{
		rrepo.save(reg);
	}
	public List<Registration> getData()
	{
		return rrepo.findAll();
	}
	public Registration getDataByUname(String uname)
	{
		Registration rg=rrepo.findById(uname).orElse(null);
		return rg;
	}
	public void deleteData(String uname)
	{
		Registration rg=rrepo.findById(uname).orElse(null);
		if(rg!=null)
		{
			rrepo.delete(rg);
		}
	}
	public Registration updateData(String uname,Registration rg)
	{
		Registration rgs=rrepo.findById(uname).orElse(null);
		if(rg!=null)
		{
			rgs.setPass(rg.getPass());
			rgs.setPhno(rg.getPhno());
			rgs.setNm(rg.getNm());
			rgs.setEmail(rg.getEmail());
		}
		return  rgs;
	}
}
