package com.davethino.fake.dto;

import com.davethino.fake.model.Guest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestDto {

    private long id;

    private String name;
    private String email;
    private String phoneNumber;

    private InvitationDto invitation;

    public GuestDto(Guest guest) {

        this.id = guest.getId();
        this.name = guest.getName();
        this.email = guest.getEmail();
        this.phoneNumber = guest.getPhoneNumber();

    }

}
