package ipz.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@RequestMapping("/")
	public String home() {
		return "Home";
	}

	@RequestMapping("/user")
	public User fetchUser() {
		return new User("user", "user", "user@zut.edu.pl");
	}

	@RequestMapping("/admin")
	public User fetchAdmin() {
		return new User("admin", "admin", "admin@zut.edu.pl");
	}
}

