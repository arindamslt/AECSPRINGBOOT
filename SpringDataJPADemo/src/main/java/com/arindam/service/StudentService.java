package com.arindam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.model.Student;
import com.arindam.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
StudentRepo srepo;
	public void addData(Student student)
	{
		srepo.save(student);
	}
	public List<Student> getData()
	{
		List<Student> slist=srepo.findAll();
		return slist;
	}
	public void deleteData(String rollno)
	{
		Student sd=srepo.findById(rollno).orElse(null);
		if(sd!=null)
		{
			srepo.delete(sd);
		}
	}
	public Student updateData(String rollno,Student student)
	{
		Student sd=srepo.findById(rollno).orElse(null);
		if(sd!=null)
		{
			sd.setRollno(rollno);
			sd.setSname(student.getSname());
			sd.setSdept(student.getSdept());
			srepo.save(sd);
			System.out.println("UPDATE DATA"+sd);
		}
		else
		{
			System.out.println("NO DATA");
		}
		return sd;
	}
	public Student fetchDataByRollno(String rollno)
	{
		Student student= srepo.findById(rollno).orElse(null);
		return student;
	}
	public List<Object[]> getRollnoName()
	{
		return srepo.getRollnoName();
	}
	public Student getDataByDept(String deptnm)
	{
		Student sd=srepo.getDataByDept(deptnm);
		return sd;
	}
	public Student findBySname(String sname)
	{
	    return srepo.findBySname(sname);
	}
}
