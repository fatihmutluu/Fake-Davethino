package com.davethino.fake.notifications.whatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppSender {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC5337e73630d25d81f4fdc359c5817810";
    public static final String AUTH_TOKEN = "be378c324aa2ce4d1cb0990905c634cc";

    public void sendMessage(String phoneNumber, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + phoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                msg)

                .create();

        System.out.println(message.getSid());
    }

}
