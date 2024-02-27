package com.arindam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arindam.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,String> {
	@Query("select s.rollno,s.sname from Student s")
public List<Object[]> getRollnoName();
@Query("select s from Student s where s.sdept=:deptnm")
public Student getDataByDept(String deptnm);
public Student findBySname(String sname);
}