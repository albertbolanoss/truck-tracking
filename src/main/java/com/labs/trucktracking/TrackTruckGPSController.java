package com.labs.trucktracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trucktracking.context.schemas.truck.TrackTruckGps;

@RestController
@RequestMapping(value = "/trackTruck")
public class TrackTruckGPSController {

  private final TrackTruckGPSProducer trackTruckGPSProducer;

  @Autowired
  TrackTruckGPSController(TrackTruckGPSProducer trackTruckGPSProducer) {
    this.trackTruckGPSProducer = trackTruckGPSProducer;
  }

  @GetMapping(value = "/producer")
  public void sendMessageToKafkaTopic(@RequestParam("truckId") String truckId,
                                      @RequestParam("latitude") String latitude,
                                      @RequestParam("longitude") String longitude) {
    this.trackTruckGPSProducer.sendMessage(new TrackTruckGps(truckId, latitude, longitude));
  }
}