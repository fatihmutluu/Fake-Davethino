package com.davethino.fake.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.davethino.fake.dto.input.GuestRequest;
import com.davethino.fake.dto.input.InvitationRequest;
import com.davethino.fake.model.Customer;
import com.davethino.fake.model.Guest;
import com.davethino.fake.model.Invitation;
import com.davethino.fake.repository.CustomerRepository;
import com.davethino.fake.repository.GuestRepository;
import com.davethino.fake.repository.InvitationRepository;
import com.davethino.fake.service.InvitationService;

@Service
public class InvitationServiceImpl implements InvitationService {

    private InvitationRepository invitationRepository;
    private GuestRepository guestRepository;
    private CustomerRepository CustomerRepository;

    public InvitationServiceImpl(InvitationRepository invitationRepository, GuestRepository guestRepository,
            CustomerRepository CustomerRepository) {
        this.invitationRepository = invitationRepository;
        this.guestRepository = guestRepository;
        this.CustomerRepository = CustomerRepository;
    }

    @Override
    public Invitation getInvitationById(long id) {
        return invitationRepository.findById(id).get();
    }

    @Override
    public List<Invitation> getAllInvitations() {
        return invitationRepository.findAll();
    }

    @Override
    public Invitation createInvitation(InvitationRequest invitationRequest) {

        Customer customer = CustomerRepository.findById((long) 3).get();
        Invitation invitation = new Invitation();
        invitation.setCustomer(customer);
        invitation.setTitle(invitationRequest.getTitle());
        invitation.setContent(invitationRequest.getContent());
        invitation.setLocation(invitationRequest.getLocation());
        invitation.setDate(LocalDate.parse(invitationRequest.getDate()));
        invitation.setStartTime(LocalTime.parse(invitationRequest.getStartTime()));
        invitation.setEndTime(LocalTime.parse(invitationRequest.getEndTime()));

        Invitation savedInvitation = invitationRepository.save(invitation);

        List<GuestRequest> guestRequests = invitationRequest.getGuests();

        for (GuestRequest guestRequest : guestRequests) {
            Guest guest = new Guest();
            guest.setName(guestRequest.getName());
            guest.setEmail(guestRequest.getEmail());
            guest.setPhoneNumber(guestRequest.getPhoneNumber());
            guest.setInvitation(savedInvitation); // Establishing the one-to-many relationship
            guestRepository.save(guest);

        }

        return savedInvitation;
    }

}