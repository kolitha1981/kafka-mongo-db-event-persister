package org.perisstent.publisher.kafkaeventpublisher.stream;

import org.perisstent.publisher.kafkaeventpublisher.message.PassengerEvent;

public interface PassengerEventPublishingService {

	void publishPassengerEvent(PassengerEvent passengerEvent);

}