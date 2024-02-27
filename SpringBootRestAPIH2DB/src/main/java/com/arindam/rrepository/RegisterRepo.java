package com.arindam.rrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arindam.model.Registration;
@Repository
public interface RegisterRepo extends JpaRepository<Registration,String> {

}
