package com.labs.trucktracking;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TruckTrackingApplication {
    private static final String topicName = "TrackTruckGps";

    private static final Short partitions = 3;

    private static final Short replicationFactor = 3;

    public static void main(String[] args) {
        SpringApplication.run(TruckTrackingApplication.class, args);
    }

    @Bean
    NewTopic trackTruckGpsTopic() {
        return new NewTopic(topicName, partitions, replicationFactor);
    }
}
