package com.arindam.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value="cst")
public class Customer {
	@Value("C2")
private String cid;
	@Value("NAYAN")
private String cname;
	@Value("5454545")
private String cphno;
}
