package com.arindam.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arindam.bean.Customer;
import com.arindam.config.SpringConfig;

public class ClientApp {
public static void main(String[] args) {
	AnnotationConfigApplicationContext  ac=new AnnotationConfigApplicationContext(SpringConfig.class);
	Customer cs=(Customer)ac.getBean("cst");
	System.out.println(cs);
}
}
