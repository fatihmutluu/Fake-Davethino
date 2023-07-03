package com.davethino.fake.notifications;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Component
public class AWSSnsClient {

        public static final String AWS_ACCESS_KEY_ID = "aws.accessKeyId";
        public static final String AWS_SECRET_KEY = "aws.secretKey";
        static {
                System.setProperty(AWS_ACCESS_KEY_ID, "AKIAUBJXYTDGK2MH2C5V");
                System.setProperty(AWS_SECRET_KEY, "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");
        }

        public AmazonSNS getSnsClient() {
                return AmazonSNSClient.builder().withRegion(Regions.EU_NORTH_1).build();

        }

}
