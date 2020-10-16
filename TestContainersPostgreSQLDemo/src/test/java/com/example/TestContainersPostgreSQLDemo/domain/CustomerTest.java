package com.example.TestContainersPostgreSQLDemo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
	
	@Test
	public void canCreateCustomer() {
		Customer customer = new Customer("Shaun", "Green");
		Assertions.assertThat(customer.getFirstName()).isEqualTo("Shaun");
		Assertions.assertThat(customer.getLastName()).isEqualTo("Green");
	}

}
