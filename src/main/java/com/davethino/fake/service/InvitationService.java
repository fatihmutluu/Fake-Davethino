package com.davethino.fake.service;

import java.util.List;

import com.davethino.fake.model.Invitation;

public interface InvitationService {

    Invitation getInvitationById(long id);

    List<Invitation> getAllInvitations();

}
