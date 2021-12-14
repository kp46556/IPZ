package ipz.userservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


//sprawdzanie czy aplikacja może wystartować
@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private UserServiceApplication controller;

	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}


