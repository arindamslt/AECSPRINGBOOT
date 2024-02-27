package com.arindam.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value="emp")
public class Employee {
	@Value("E1")
private String eid;
	@Value("SAMIR")
private String ename;
	@Value("MANAGER")
private String desig;
	@Value("${my.list.friends}")
private List<String> friends;
	@Value("${my.set.phno}")
private Set<String> phno;
	@Value("#{${product.purchase}}")
private Map<String,Integer> products;
	@Value("#{${doc.info}}")
private Properties docs;

}
