package com.davethino.fake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davethino.fake.model.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

}
