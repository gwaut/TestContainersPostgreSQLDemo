package com.example.TestContainersPostgreSQLDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TestContainersPostgreSqlDemoApplicationTests extends BaseIntegrationTest {

	@Autowired
	private EntityManager em;
	
	@Test
	void contextLoads() {
	}

	@Test
    public void checkPostgreSQLVersion() throws Exception {
		Query query = em.createNativeQuery("SELECT version()");
		String version = (String) query.getSingleResult();
        assertTrue(version.startsWith("PostgreSQL 12.3"));
    }
	
	@Test
	public void checkApplicationUser() {
		Query query = em.createNativeQuery("SELECT user");
		String appUser = (String) query.getSingleResult();
        assertThat(appUser).isEqualTo("demo_app");	
	}
}
