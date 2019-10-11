package br.com.creative.devlet.service;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.javax.ws.rs.core.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class EnterpriseServiceImplTest {

    @TestConfiguration
    static class EnterpriseServiceImplTestContextConfiguration{
        @Bean
        public EnterpriseService enterpriseService(){
            return new EnterpriseServiceImpl();
        }
    }

}
