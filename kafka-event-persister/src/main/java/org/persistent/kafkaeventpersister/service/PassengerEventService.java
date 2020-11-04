package org.persistent.kafkaeventpersister.service;

import org.persistent.kafkaeventpersister.model.PassengerEvent;

public interface PassengerEventService {
	
	PassengerEvent save(PassengerEvent passengerEvent);

}
