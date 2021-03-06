package pl.sii.eu.base;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.sii.eu.producer.ProducerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("validation-test")
public abstract class RestBase {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }
}
