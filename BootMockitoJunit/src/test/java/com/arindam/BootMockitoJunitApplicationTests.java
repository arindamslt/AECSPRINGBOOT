package com.arindam;

import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.arindam.model.User;
import com.arindam.repository.UserRepository;
import com.arindam.service.UserService;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BootMockitoJunitApplicationTests {

	@MockBean
	UserRepository umock;
	@Autowired
	UserService uservice;
	@Test
	public void testFetchData()
	{
		when(umock.findAll()).thenReturn(Stream.of(new User(1,"ANUP",24,"an@gmail.com")).collect(Collectors.toList()));
		assertEquals(1,uservice.getData().size());
	}
	@Test
	public void testById()
	{
		Integer id=101;
		User useritem=new User(101,"ALOKE",25,"KOLKATA");
		System.out.println(Optional.of(Optional.of(useritem).get()));
		
		when(umock.findById(101)).thenReturn(Optional.of(Optional.of(useritem).get()));
	   assertEquals(new User(101,"ALOKE",25,"KOLKATA"),uservice.getbyId(101));
		 
	}
	@Test
	public void testSave()
	{
		User user=new User(102,"NAYAN",32,"KOLKATA");
		when(umock.save(user)).thenReturn(user);
		assertEquals(user,uservice.addData(user));
	}
	@Test
   public void testDelete()
   {
		User user=new User(102,"NAYAN",32,"KOLKATA");
		uservice.deleteData(user);
		verify(umock,times(1)).delete(user);
   }
}
