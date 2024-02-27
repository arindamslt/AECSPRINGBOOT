package com.arindam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arindam.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
