package com.davethino.fake.resolver;

import com.davethino.fake.dto.CustomerDto;
import com.davethino.fake.dto.InvitationDto;
import com.davethino.fake.model.Customer;
import com.davethino.fake.service.CustomerService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerResolver implements GraphQLResolver<CustomerDto> {

    private final CustomerService customerService;

    public CustomerResolver(CustomerService customerService) {
        this.customerService = customerService;
    }

    // ! Retrieves the list of invitations associated with the customer
    public List<InvitationDto> getInvitations(CustomerDto customerDto) {
        Customer customer = customerService.findById(customerDto.getId());
        return customer.getInvitations().stream().map(invitation -> {
            return new InvitationDto(invitation);
        }).collect(Collectors.toList());
    }

    // ! Retrieves the full name of the customer by combining the name and last name
    public String getFullName(CustomerDto customerDto) {
        return customerDto.getName() + " " + customerDto.getLastName();
    }
}
