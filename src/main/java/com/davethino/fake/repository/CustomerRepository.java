package com.davethino.fake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davethino.fake.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUsernameOrEmail(String username, String email);

}
