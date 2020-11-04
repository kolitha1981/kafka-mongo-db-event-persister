package org.persistent.kafkaeventpersister.service;

import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.repository.PassengerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerEventServiceImpl implements PassengerEventService {

	@Autowired
	private PassengerEventRepository passengerEventRepository;
	
	@Override
	public PassengerEvent save(final PassengerEvent passengerEvent) {
		return this.passengerEventRepository.save(passengerEvent);
	}

}
