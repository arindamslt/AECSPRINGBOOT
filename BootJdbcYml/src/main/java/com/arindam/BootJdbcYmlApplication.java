package com.arindam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BootJdbcYmlApplication implements CommandLineRunner{
	@Autowired
JdbcTemplate template;
	public static void main(String[] args) {
		SpringApplication.run(BootJdbcYmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String insert_sql="insert into account values('300','SANJIB',15000.00)";
		String select_sql="select * from account order by accno";
		int n=template.update(insert_sql);
		List aclist=template.queryForList(select_sql);
		aclist.stream().forEach(System.out::println);
	}

}
