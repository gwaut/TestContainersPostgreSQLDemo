package com.example.TestContainersPostgreSQLDemo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
@ContextConfiguration(initializers = {BaseIntegrationTest.Initializer.class})
public class BaseIntegrationTest {
	
	// Create a singleton container for all tests
	static final PostgreSQLContainer<?> postgreSQLContainer;
	static {
		postgreSQLContainer = new PostgreSQLContainer<>("postgres:12.3")
			      .withInitScript("db/docker/init-db.sql");
		postgreSQLContainer.start();
	}
	
	
	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
          TestPropertyValues.of(
            "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl() 
          ).applyTo(configurableApplicationContext.getEnvironment());
      }
		
  }

}
