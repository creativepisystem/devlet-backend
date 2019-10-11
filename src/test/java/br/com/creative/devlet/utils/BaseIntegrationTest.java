package br.com.creative.devlet.utils;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.repo.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.time.Duration;

import static java.util.Arrays.asList;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
//@ContextConfiguration(initializers = {BaseIntegrationTest.Initializer.class})
public abstract class BaseIntegrationTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    protected User existingUser, newUser, updateUser;
//
//    protected void setupTestData() {
//        newUser = TestHelper.buildUser();
//
//        existingUser = TestHelper.buildUser();
//        existingUser = userRepository.save(existingUser);
//
//        updateUser = TestHelper.buildUser();
//        updateUser = userRepository.save(updateUser);
//    }
//
//    protected void cleanupTestData() {
//        if(newUser.getId() != null) {
//            userRepository.deleteById(newUser.getId());
//        }
//        userRepository.deleteAll(userRepository.findAllById(asList(existingUser.getId(), updateUser.getId())));
//    }
//
//    public static PostgreSQLContainer postgreSQLContainer =
//            (PostgreSQLContainer) new PostgreSQLContainer("postgres:11")
//                    .withDatabaseName("devlet_test")
//                    .withUsername("devlet")
//                    .withPassword("devlet")
//                    .withStartupTimeout(Duration.ofSeconds(600));
//
//    static {
//        postgreSQLContainer.start();
//    }
//
//    static class Initializer
//            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            TestPropertyValues.of(
//                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
//                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
//                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
//            ).applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
}
