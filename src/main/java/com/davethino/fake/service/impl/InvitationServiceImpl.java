package com.davethino.fake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davethino.fake.model.Invitation;
import com.davethino.fake.repository.InvitationRepository;
import com.davethino.fake.service.InvitationService;

@Service
public class InvitationServiceImpl implements InvitationService {

    private InvitationRepository invitationRepository;

    public InvitationServiceImpl(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    @Override
    public Invitation getInvitationById(long id) {
        return invitationRepository.findById(id).get();
    }

    @Override
    public List<Invitation> getAllInvitations() {
        return invitationRepository.findAll();
    }
}
