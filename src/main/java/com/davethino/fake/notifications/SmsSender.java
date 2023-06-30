package com.davethino.fake.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsSender {
    private static final Logger logger = LoggerFactory.getLogger(SmsSender.class);

    public static void sendSms(String phoneNumber) {
        logger.warn("Sending SMS to recipient: {}", phoneNumber);
        // Implementation for sending the SMS
        // ...
    }
}
