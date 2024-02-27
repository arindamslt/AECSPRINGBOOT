package com.arindam.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.arindam.entity.Employee;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("AppDB");
     EntityTransaction tx=null;
     EntityManager em=emf.createEntityManager();
     tx=em.getTransaction();
     tx.begin();
     Employee emp1=new Employee();
     emp1.setEname("AYAN");
     emp1.setEphno("2222");
     emp1.setEmail("ay@gmail.com");
     emp1.setEdeisg("MANAGER");
     emp1.setJoinddt(new Date());
     emp1.setWorkhr(new Date());
     Employee emp2=new Employee();
     emp2.setEname("AJOY");
     emp2.setEphno("3333");
     emp2.setEmail("aj@gmail.com");
     emp2.setEdeisg("MANAGER");
     emp2.setJoinddt(new Date());
     emp2.setWorkhr(new Date());
     em.persist(emp1);
     em.persist(emp2);
     tx.commit();
     emf.close();
	}

}
