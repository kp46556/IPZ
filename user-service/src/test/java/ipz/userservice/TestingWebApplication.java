package ipz.userservice;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


//sprawdzanie kodu bez potrzeby uruchomienia serwera (zwroty user i admin)
@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplication {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ReturnDefaultUserMessage() throws Exception {
        MvcResult result=mockMvc.perform(get("/user")).andDo(print()).
                andExpect(status().isOk()).andReturn();
    }


    @Test
    public void ReturnDefaultAdminMessage() throws Exception {
        MvcResult result=mockMvc.perform(get("/admin")).andDo(print()).
                andExpect(status().isOk()).andReturn();
    }
}