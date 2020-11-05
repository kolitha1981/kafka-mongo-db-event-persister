package org.persistent.kafkaeventpersister.service;

import org.persistent.kafkaeventpersister.model.PassengerEvent;

public interface PassengerEventService {
	
	PassengerEvent save(PassengerEvent passengerEvent);
	
	PassengerEvent findByEventId(String id);
	
	PassengerEvent findByUserId(Long userId);

}
