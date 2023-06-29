package com.davethino.fake.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.davethino.fake.model.Invitation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvitationDto {

    private long id;

    private String title;
    private String content;
    private String location;

    private String date;
    private String startTime;
    private String endTime;

    private List<GuestDto> guests;

    private CustomerDto customer;

    private String dateStartEnd;

    public InvitationDto(Invitation invitation) {

        this.id = invitation.getId();
        this.title = invitation.getTitle();
        this.content = invitation.getContent();
        this.location = invitation.getLocation();
        this.date = invitation.getDate().toString();
        this.startTime = invitation.getStartTime().toString();
        this.endTime = invitation.getEndTime().toString();

    }
}
