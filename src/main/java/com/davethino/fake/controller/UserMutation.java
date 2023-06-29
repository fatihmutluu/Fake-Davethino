package com.davethino.fake.controller;

import org.springframework.stereotype.Component;

import com.davethino.fake.dto.CustomerDto;
import com.davethino.fake.dto.input.LoginDto;
import com.davethino.fake.dto.input.RegisterDto;
import com.davethino.fake.service.CustomerService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class UserMutation implements GraphQLMutationResolver {

    CustomerService customerService;

    public UserMutation(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerDto register(RegisterDto registerDto) {

        return new CustomerDto(customerService.register(registerDto));

    }

    public String login(LoginDto loginDto) {

        return customerService.login(loginDto);

    }
}
