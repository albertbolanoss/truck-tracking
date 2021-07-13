package com.labs.trucktracking;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import trucktracking.context.schemas.truck.TrackTruckGps;

@Service
@Slf4j
public class TrackTruckGPSProducer {
    private final KafkaTemplate<String, TrackTruckGps> kafkaTemplate;

    @Autowired
    public TrackTruckGPSProducer(KafkaTemplate<String, TrackTruckGps> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(TrackTruckGps trackTruckGps) {
        this.kafkaTemplate.send("TrackTruckGps", trackTruckGps.getTruckId().toString(), trackTruckGps);
        log.info(String.format("Produced user -> %s", trackTruckGps));
    }

}
