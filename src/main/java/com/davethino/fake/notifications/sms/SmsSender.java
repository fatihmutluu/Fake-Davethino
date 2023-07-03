package com.davethino.fake.notifications.sms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.davethino.fake.notifications.AWSSnsClient;

@Service
public class SmsSender {

    private AmazonSNS snsClient;

    public SmsSender(AWSSnsClient snsClient) {
        this.snsClient = snsClient.getSnsClient();
    }

    public void sendSms(String phoneNumber, String message) {
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
        smsAttributes.put("AWS.SNS.SMS.SenderID",
                new MessageAttributeValue().withStringValue("DaveThino")
                        .withDataType("String"));
        smsAttributes.put("AWS.SNS.SMS.SMSType",
                new MessageAttributeValue().withStringValue("Transactional")
                        .withDataType("String"));
        PublishResult result = snsClient
                .publish(new PublishRequest().withMessage(message).withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result.getMessageId());
    }

}
