package com.arindam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BootJdbcDemoApplication implements CommandLineRunner{
	@Autowired
JdbcTemplate template;
	public static void main(String[] args) {
		SpringApplication.run(BootJdbcDemoApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("JDBC APPLICATION");
		String sql="insert into account values(101,'ARIJIT','434344')";
		int n=template.update(sql);
		String select_sql="select * from account order by accno";
		List aclist=template.queryForList(select_sql);
		aclist.stream().forEach(System.out::println);
	}

}
