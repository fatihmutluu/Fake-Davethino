package com.davethino.fake.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davethino.fake.dto.CustomerDto;
import com.davethino.fake.service.CustomerService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class CustomerCtrl implements GraphQLQueryResolver {

    @Autowired
    private CustomerService customerService;

    // ! Constructor
    public CustomerCtrl(CustomerService customerService) {
        this.customerService = customerService;
    }

    // ! Retrieves all customers
    public Iterable<CustomerDto> getCustomers() {
        return customerService.findAll().stream().map(customer -> new CustomerDto(customer))
                .collect(Collectors.toList());
    }

    // ! Retrieves a customer by ID
    public CustomerDto getCustomer(long id) {
        return new CustomerDto(customerService.findById(id));
    }

}
