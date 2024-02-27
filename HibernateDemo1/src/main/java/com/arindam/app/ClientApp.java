package com.arindam.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.arindam.entity.CustomerMs;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LOADING DRIVER ESTABLISH THE CONNECTION CREATE STATEMENT PREPARESTATEMENT
EntityManagerFactory emf=Persistence.createEntityManagerFactory("AppDB");
EntityTransaction tx=null;
//PERFORM INSERT UPDATE DELETE OPERATION
EntityManager em=emf.createEntityManager();
//TRANSACTION CREATED
tx=em.getTransaction();
//TRANSACTION STARTED
tx.begin();
CustomerMs cs1=new CustomerMs("C1","ANUP","4559559");
CustomerMs cs2=new CustomerMs("C2","AYAN","4559566");
em.persist(cs1);
//em.persist(cs2);
tx.commit();
emf.close();

	}

}
