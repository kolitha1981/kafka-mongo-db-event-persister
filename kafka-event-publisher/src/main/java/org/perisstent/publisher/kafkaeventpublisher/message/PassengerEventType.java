package org.perisstent.publisher.kafkaeventpublisher.message;

public enum PassengerEventType {
	CREATE_JOURNEY,	
	END_JOURNEY,
	REQUEST_NEW_CARD,
	INACTIVATE_CARD,
	VALIDATE_TRAVEL_REQUEST,
	RELOAD_ACCOUNT,
	CHECK_HISTORY;
}
