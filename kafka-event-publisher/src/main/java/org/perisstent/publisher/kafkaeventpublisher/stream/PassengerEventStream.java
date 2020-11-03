package org.perisstent.publisher.kafkaeventpublisher.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PassengerEventStream {

	String PASSENGER_EVENTS_TOPIC_OUTPUT = "passenger-events-publisher";
	
	@Output(PASSENGER_EVENTS_TOPIC_OUTPUT)
	MessageChannel getEventPublishStream();
}
