package com.davethino.fake.controller;

import org.springframework.stereotype.Component;

import com.davethino.fake.dto.InvitationDto;
import com.davethino.fake.dto.input.InvitationRequest;
import com.davethino.fake.service.InvitationService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class InvitationMutation implements GraphQLMutationResolver {

    private InvitationService invitationService;

    // ! Constructor
    public InvitationMutation(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    // ! Creates a new invitation
    public InvitationDto createInvitation(InvitationRequest invitationRequest) {
        // Create an InvitationDto object using the created invitation from
        // invitationService
        return new InvitationDto(invitationService.createInvitation(invitationRequest));
    }
}
