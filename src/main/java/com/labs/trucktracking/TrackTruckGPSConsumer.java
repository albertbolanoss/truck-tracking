package com.labs.trucktracking;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import trucktracking.context.schemas.truck.TrackTruckGps;

@Service
@Slf4j
public class TrackTruckGPSConsumer {
    @KafkaListener(topics = "TrackTruckGps", groupId = "myApplication")
    public void consume(ConsumerRecord<String, TrackTruckGps> record) {
        log.info(String.format("Consumed message -> %s", record.value()));
    }
}
