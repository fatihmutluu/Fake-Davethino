package com.davethino.fake.resolver;

import org.springframework.stereotype.Component;

import com.davethino.fake.dto.GuestDto;
import com.davethino.fake.dto.InvitationDto;
import com.davethino.fake.model.Guest;
import com.davethino.fake.service.GuestService;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class GuestResolver implements GraphQLResolver<GuestDto>{

    private final GuestService guestService;

    public GuestResolver(GuestService guestService) {
        this.guestService = guestService;
    }

    public InvitationDto getInvitation(GuestDto guestDto) {

        Guest guest = guestService.getGuestById(guestDto.getId());
        return new InvitationDto(guest.getInvitation());
        
    }
}
