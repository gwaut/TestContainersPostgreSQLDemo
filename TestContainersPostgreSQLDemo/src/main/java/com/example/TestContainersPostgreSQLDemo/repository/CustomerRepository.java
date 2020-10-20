package com.example.TestContainersPostgreSQLDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.TestContainersPostgreSQLDemo.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
