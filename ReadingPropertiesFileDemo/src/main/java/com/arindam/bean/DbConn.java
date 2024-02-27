package com.arindam.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value="db")
public class DbConn {
	@Value("${driver}")
private String driver;
	@Value("${url}")
private String url;
	@Value("${uname}")
private String uname;
	@Value("${password}")
private String pass;
}
