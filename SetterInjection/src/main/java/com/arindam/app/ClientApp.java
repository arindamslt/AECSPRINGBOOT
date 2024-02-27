package com.arindam.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arindam.bean.Employee;
import com.arindam.config.SpringConfig;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
Employee em=(Employee)ac.getBean("emp");
System.out.println(em);
	}

}
