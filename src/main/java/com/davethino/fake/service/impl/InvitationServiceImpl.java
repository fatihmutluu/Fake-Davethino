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
import com.davethino.fake.notifications.email.EmailDto;
import com.davethino.fake.notifications.email.EmailSender;
import com.davethino.fake.notifications.sms.SmsDto;
import com.davethino.fake.notifications.sms.SmsSender;
import com.davethino.fake.notifications.whatsapp.WhatsAppSender;
import com.davethino.fake.repository.CustomerRepository;
import com.davethino.fake.repository.GuestRepository;
import com.davethino.fake.repository.InvitationRepository;
import com.davethino.fake.service.InvitationService;

import jakarta.transaction.Transactional;

@Service
public class InvitationServiceImpl implements InvitationService {

    private InvitationRepository invitationRepository;
    private GuestRepository guestRepository;
    private CustomerRepository CustomerRepository;
    private SmsSender smsSender;
    private EmailSender emailSender;
    private WhatsAppSender whatsAppSender;

    public InvitationServiceImpl(InvitationRepository invitationRepository, GuestRepository guestRepository,
            CustomerRepository CustomerRepository, SmsSender smsSender, EmailSender emailSender,
            WhatsAppSender whatsAppSender) {
        this.invitationRepository = invitationRepository;
        this.guestRepository = guestRepository;
        this.CustomerRepository = CustomerRepository;
        this.smsSender = smsSender;
        this.emailSender = emailSender;
        this.whatsAppSender = whatsAppSender;
    }

    // ! Retrieves an invitation by ID
    @Override
    public Invitation getInvitationById(long id) {
        return invitationRepository.findById(id).get();
    }

    // ! Retrieves all invitations
    @Override
    public List<Invitation> getAllInvitations() {
        return invitationRepository.findAll();
    }

    // ! Creates a new invitation
    @Transactional
    @Override
    public Invitation createInvitation(InvitationRequest invitationRequest) {

        Customer customer = CustomerRepository.findById((long) invitationRequest.getUserId()).get();
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

        // ? Creates a new guest for each guest request
        for (GuestRequest guestRequest : guestRequests) {
            Guest guest = new Guest();
            guest.setAttending(false);
            guest.setName(guestRequest.getName());
            guest.setPhoneNumber(guestRequest.getPhoneNumber());
            guest.setEmail(guestRequest.getEmail());

            emailSender.sendEmail(guest.getEmail(),
                    customer.getName() + " Invited You",
                    new EmailDto(guest.getName(), customer.getName(),
                            invitation.getTitle(), invitation.getLocation(), invitation.getDate(),
                            invitation.getStartTime())
                            .toString());

            smsSender.sendSms(guest.getPhoneNumber(), new SmsDto(guest.getName(), customer.getName(),
                    invitation.getTitle(), invitation.getLocation(), invitation.getDate(), invitation.getStartTime())
                    .toString());

            whatsAppSender.sendMessage(guest.getPhoneNumber(), new SmsDto(guest.getName(), customer.getName(),
                    invitation.getTitle(), invitation.getLocation(), invitation.getDate(), invitation.getStartTime())
                    .toString());

            guest.setInvitation(savedInvitation);
            guestRepository.save(guest);

        }

        return savedInvitation;
    }

}
