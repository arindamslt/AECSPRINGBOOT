package com.arindam.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.arindam.entity.Student;
import com.arindam.entity.Teacher;

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
Teacher tr1=new Teacher("T1","AMIT SIR");
Teacher tr2=new Teacher("T2","ALOKE SIR");
Student  sd1=new Student("1","AJOY",tr1);

Student sd2=new Student("2","ROBIN",tr2);
em.persist(tr1);
em.persist(tr2);
em.persist(sd1);
em.persist(sd2);
String jpql="select s.sname,t.tname from Student s join s.tr t";
Query query=em.createQuery(jpql);
List<Object[]> plist=query.getResultList();
plist.stream().map(p->p[0]+"===>"+p[1]).forEach(System.out::println);
tx.commit();
emf.close();


	}

}
