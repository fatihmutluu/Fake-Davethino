package com.davethino.fake.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailSender {
    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    public static void sendEmail(String email) {
        logger.warn("Sending email to recipient: {}", email);
        // Implementation for sending the email
        // ...
    }
}
