package com.davethino.fake.resolver;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.davethino.fake.dto.CustomerDto;
import com.davethino.fake.dto.GuestDto;
import com.davethino.fake.dto.InvitationDto;
import com.davethino.fake.model.Invitation;
import com.davethino.fake.service.InvitationService;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class InvitationResolver implements GraphQLResolver<InvitationDto> {

    private final InvitationService invitationService;

    public InvitationResolver(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    public List<GuestDto> getGuests(InvitationDto invitationDto) {
        Invitation invitation = invitationService.getInvitationById(invitationDto.getId());
        return invitation.getGuests().stream().map(guest -> {
            return new GuestDto(guest);
        }).collect(Collectors.toList());
    }

    public CustomerDto getCustomer(InvitationDto invitationDto) {
        Invitation invitation = invitationService.getInvitationById(invitationDto.getId());
        return new CustomerDto(invitation.getCustomer());
    }

    public String getDateStartEnd(InvitationDto invitationDto) {
        return invitationDto.getDate() + " " + invitationDto.getStartTime() + "-" + invitationDto.getEndTime();
    }
}
