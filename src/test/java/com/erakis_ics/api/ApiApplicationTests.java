package com.erakis_ics.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.erakis_ics.api.entity.Login;
import com.erakis_ics.api.services.LoginServices;

/*  
 * @author by: icarlos 
 */

@RunWith(value = SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private LoginServices loginServicesTest;
	
	public void loginSaveTest() {
		// loginServicesTest.save();
	}

	public void loginListAllTest() {
		try {
			// loginServicesTest.loginFindAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void loginFindByIdTest() throws Exception {
		Login l = loginServicesTest.loginFindById(15L);
		assertEquals("15",String.valueOf(l.getId()));
		assertEquals("scott",l.getLogin());
		assertEquals("stapp123",l.getLoginPassword());
		assertEquals("@creed",l.getUserName());
	}
	
	public void deleteLoginByIdTest() throws Exception {
		loginServicesTest.deleteById(2L);
		//Optional<Login> optionalLogin = loginRepository.findById(2L);
		
		//assertFalse(optionalLogin.isPresent());
	}
	
	@Test
	public void status() {
		loginServicesTest.expiredSession();
	}

}
