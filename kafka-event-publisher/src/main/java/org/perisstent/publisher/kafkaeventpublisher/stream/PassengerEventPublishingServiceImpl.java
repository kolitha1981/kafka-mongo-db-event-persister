package org.perisstent.publisher.kafkaeventpublisher.stream;

import org.perisstent.publisher.kafkaeventpublisher.message.PassengerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class PassengerEventPublishingServiceImpl implements PassengerEventPublishingService {

	@Autowired
	private PassengerEventStream passengerEventStream;

	@Override
	public void publishPassengerEvent(final PassengerEvent passengerEvent) {
		final MessageChannel messageChannel = this.passengerEventStream.getEventPublishStream();
		messageChannel.send(MessageBuilder.withPayload(passengerEvent)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}

}
