package com.davethino.fake.dto;

import java.util.List;

import com.davethino.fake.model.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private Long id;

    private String name;
    private String lastName;
    private String username;

    private String password;
    private String email;

    private Boolean isAdmin;

    private List<InvitationDto> invitations;

    private String fullName;

    public CustomerDto(Customer customer) {

        this.id = customer.getId();
        this.name = customer.getName();
        this.lastName = customer.getLastName();
        this.password = customer.getPassword();
        this.email = customer.getEmail();
        this.username = customer.getUsername();
        this.isAdmin = customer.getIsAdmin();

    }

}
