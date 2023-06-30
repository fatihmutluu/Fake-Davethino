package com.davethino.fake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davethino.fake.model.Guest;
import com.davethino.fake.repository.GuestRepository;
import com.davethino.fake.service.GuestService;

@Service
public class GuestServiceImpl implements GuestService {

    private GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // ! Retrieves a guest by ID
    @Override
    public Guest getGuestById(long id) {
        return guestRepository.findById(id).get();
    }

    // ! Retrieves all guests
    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

}
