package com.arindam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arindam.model.Registration;
@Repository
public interface RegisterRepository extends JpaRepository<Registration,String> {
@Query("from Registration r where r.uname=:uname and r.pass=:pass")
public Registration checkLogin(String uname,String pass);
}
