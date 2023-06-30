package com.davethino.fake.controller;

import org.springframework.stereotype.Component;

import com.davethino.fake.dto.CustomerDto;
import com.davethino.fake.dto.input.LoginDto;
import com.davethino.fake.dto.input.RegisterDto;
import com.davethino.fake.service.CustomerService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class UserMutation implements GraphQLMutationResolver {

    private CustomerService customerService;

    // ! Constructor
    public UserMutation(CustomerService customerService) {
        this.customerService = customerService;
    }

    // ! Registers a new customer
    public CustomerDto register(RegisterDto registerDto) {
        // Create a CustomerDto object using the registered customer from
        // customerService
        return new CustomerDto(customerService.register(registerDto));
    }

    // ! Performs user login
    public String login(LoginDto loginDto) {
        // Perform login and return the result as a string
        return customerService.login(loginDto);
    }
}
