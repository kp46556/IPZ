package ipz.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

//sprawdzanie poprawności generowanych zwrotów dla user i admin
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ShouldReturnDefaultUser() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/user", String.class)).contains("user", "user", "user@zut.edu.pl");
    }

    @Test
    public void ShouldReturnDefaultAdmin() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/admin", String.class)).contains("admin", "admin", "admin@zut.edu.pl");
    }
}
