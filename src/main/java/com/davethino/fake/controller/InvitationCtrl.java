package com.davethino.fake.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davethino.fake.dto.InvitationDto;
import com.davethino.fake.dto.input.InvitationRequest;
import com.davethino.fake.service.InvitationService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class InvitationCtrl implements GraphQLQueryResolver {

    @Autowired
    private InvitationService invitationService;

    public InvitationCtrl(InvitationService invitationService) {
        this.invitationService = invitationService;

    }

    public InvitationDto getInvitation(long id) {

        return new InvitationDto(invitationService.getInvitationById(id));

    }

    public Iterable<InvitationDto> getInvitations() {

        return invitationService.getAllInvitations().stream().map(invitation -> new InvitationDto(invitation))
                .collect(Collectors.toList());

    }


}
