package com.davethino.fake.service;

import java.util.List;

import com.davethino.fake.dto.CustomerDto;
import com.davethino.fake.dto.input.LoginDto;
import com.davethino.fake.dto.input.RegisterDto;
import com.davethino.fake.model.Customer;

import lombok.extern.java.Log;

public interface CustomerService {

    Customer findById(long id);

    List<Customer> findAll();

    Customer register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
