package com.example.TestContainersPostgreSQLDemo.repository;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TestContainersPostgreSQLDemo.BaseIntegrationTest;
import com.example.TestContainersPostgreSQLDemo.domain.Customer;

public class CustomerRepositoryIntegrationTest extends BaseIntegrationTest{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void canSaveCustomer() {
		assertThat(customerRepository.count()).isEqualTo(0);
		Customer customer = new Customer("Shaun", "Green");
		customerRepository.save(customer);
		assertThat(customerRepository.count()).isEqualTo(1);
	}
	
}
