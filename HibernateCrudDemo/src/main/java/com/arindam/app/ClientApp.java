package com.arindam.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.arindam.entity.Product;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EntityManagerFactory emf=Persistence.createEntityManagerFactory("AppDB");
EntityTransaction tx=null;
EntityManager em=emf.createEntityManager();
tx=em.getTransaction();
tx.begin();
Product pr1=new Product("P1","TV",5,25000.00);
Product pr2=new Product("P2","REFRIGERATOR",12,27000.00);
//em.persist(pr1);
//em.persist(pr2);
//FETCHING DATA
String jpql="select p from Product p order by p.pname";
Query query=em.createQuery(jpql);
List<Product> plist=query.getResultList();
plist.stream().forEach(System.out::println);
//delete data
/*Product ps=em.find(Product.class,"P2");
if(ps!=null)
{
	em.remove(ps);
}*/
List<Product> plist1=query.getResultList();
plist1.stream().forEach(System.out::println);

//update data
/*Product pst=em.find(Product.class,"P1");
if(pst!=null)
{
	pst.setPname("TAB");
	pst.setPqty(6);
	pst.setPrice(18000.00);
	em.persist(pst);
}*/
List<Product> plist2=query.getResultList();
plist2.stream().forEach(System.out::println);
//JPQL
//String jpql1="select p from Product p where p.pname=:v_pname";
String hql="from Product p  where p.pname=:v_pname ";
//Query query1=em.createQuery(jpql1);
Query query1=em.createQuery(hql);
query1.setParameter("v_pname","TAB");
List<Product> plists=query1.getResultList();
plists.stream().forEach(System.out::println);
tx.commit();
emf.close();
	}

}
