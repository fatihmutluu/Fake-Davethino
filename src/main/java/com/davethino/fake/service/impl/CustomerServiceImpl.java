package com.davethino.fake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davethino.fake.dto.input.LoginDto;
import com.davethino.fake.dto.input.RegisterDto;
import com.davethino.fake.model.Customer;
import com.davethino.fake.repository.CustomerRepository;
import com.davethino.fake.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {

        List<Customer> customers = customerRepository.findAll();
        return customers;

    }

    @Override
    public Customer findById(long id) {

        return customerRepository.findById(id).get();

    }

    @Override
    public Customer register(RegisterDto customer) {

        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setUsername(customer.getUsername());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setIsAdmin(false);

        return customerRepository.save(newCustomer);

    }

    @Override
    public String login(LoginDto loginDto) {
        Customer customer = customerRepository.findByUsernameOrEmail(loginDto.getEmailOrUsername(),
                loginDto.getEmailOrUsername());

        if (customer != null) {
            if (customer.getPassword().equals(loginDto.getPassword())) {
                return "connection successful";
            } else {
                return "invalid password";
            }
        } else {
            return "no user found";
        }
    }
}
