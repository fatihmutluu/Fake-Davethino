package com.davethino.fake.dto.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvitationRequest {
    
    private String title;
    private String content;
    private String location;

    private String date;
    private String startTime;
    private String endTime;

    private List<GuestRequest> guests;

}
