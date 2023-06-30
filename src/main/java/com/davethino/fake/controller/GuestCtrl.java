package com.davethino.fake.controller;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.davethino.fake.dto.GuestDto;
import com.davethino.fake.service.GuestService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class GuestCtrl implements GraphQLQueryResolver {

    private GuestService guestService;

    // ! Constructor
    public GuestCtrl(GuestService guestService) {
        this.guestService = guestService;
    }

    // ! Retrieves a guest by ID
    public GuestDto getGuest(long id) {
        return new GuestDto(guestService.getGuestById(id));
    }

    // ! Retrieves all guests
    public Iterable<GuestDto> getGuests() {
        return guestService.getAllGuests().stream().map(guest -> new GuestDto(guest)).collect(Collectors.toList());
    }
}
