package com.arindam.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arindam.bean.Customer;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext();
ac.scan("com.arindam");//scan the classes
ac.refresh();//creating the object
//Customer cs=(Customer)ac.getBean("customer");
Customer cs=(Customer)ac.getBean("cst");
System.out.println(cs);
	}

}