package com.davethino.fake.notifications.sms;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SmsDto {

    private String guestName;
    private String customerName;
    private String title;
    private String location;
    private LocalDate date;
    private LocalTime startTime;

    @Override
    public String toString() {
        return "Hi " + guestName + ", " + customerName + " has invited you to " + title + " at " + location + " on "
                + date + " at " + startTime + ". See you there!";
    }

}
