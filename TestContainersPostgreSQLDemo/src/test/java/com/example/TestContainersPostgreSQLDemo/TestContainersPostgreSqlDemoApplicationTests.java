package com.example.TestContainersPostgreSQLDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {TestContainersPostgreSqlDemoApplicationTests.Initializer.class})
class TestContainersPostgreSqlDemoApplicationTests {

	 @Container
	 public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:12.3")
	      .withInitScript("db/docker/init-db.sql");
	 
	 static class Initializer
     implements ApplicationContextInitializer<ConfigurableApplicationContext> {
       public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
           TestPropertyValues.of(
             "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl() //,
//             "spring.datasource.username=" + postgreSQLContainer.getUsername(),
//             "spring.datasource.password=" + postgreSQLContainer.getPassword()
           ).applyTo(configurableApplicationContext.getEnvironment());
       }
   }
	 
	@Test
	void contextLoads() {
	}

}
