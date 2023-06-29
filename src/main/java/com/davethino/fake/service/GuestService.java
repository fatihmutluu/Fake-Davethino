package com.davethino.fake.service;

import java.util.List;

import com.davethino.fake.model.Guest;

public interface GuestService {
    
    Guest getGuestById(long id);

    List<Guest> getAllGuests();

}
