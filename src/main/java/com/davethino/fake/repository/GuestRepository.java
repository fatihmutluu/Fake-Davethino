package com.davethino.fake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davethino.fake.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
