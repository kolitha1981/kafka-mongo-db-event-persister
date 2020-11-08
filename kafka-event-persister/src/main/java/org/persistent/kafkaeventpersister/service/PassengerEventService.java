package org.persistent.kafkaeventpersister.service;

import java.util.List;

import org.persistent.kafkaeventpersister.model.PassengerEvent;

public interface PassengerEventService {
	
	PassengerEvent save(PassengerEvent passengerEvent);
	
	PassengerEvent findByEventId(String id);
	
	PassengerEvent findByUserId(Long userId);
	
	boolean save(final List<PassengerEvent> passengerEvents);

}
