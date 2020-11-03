package org.perisstent.publisher.kafkaeventpublisher.message;

import java.util.HashMap;
import java.util.Map;

public class PassengerEvent {

	private Long passengerId;
	private PassengerEventType passengerEventType;
	private Map<String, String> passengerEventData;

	private PassengerEvent(Long passengerId, PassengerEventType passengerEventType,
			Map<String, String> passengerEventData) {
		this.passengerId = passengerId;
		this.passengerEventType = passengerEventType;
		this.passengerEventData = passengerEventData;
	}

	public String getEventDataValueof(final String eventKey) {
		return this.passengerEventData.get(eventKey);
	}

	public static class PassengerEventBuilder {

		private Long passengerId;
		private PassengerEventType passengerEventType;
		private Map<String, String> passengerEventData = new HashMap<>();

		public PassengerEventBuilder(Long passengerId, PassengerEventType passengerEventType) {
			this.passengerEventType = passengerEventType;
			this.passengerId = passengerId;
		}

		public PassengerEventBuilder addEventData(final String eventKey, final String eventData) {
			this.passengerEventData.put(eventKey, eventData);
			return this;
		}

		public PassengerEvent build() {
			return new PassengerEvent(passengerId, passengerEventType, passengerEventData);
		}

	}

}
