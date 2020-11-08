package org.persistent.kafkaeventpersister.service;

import java.util.List;

import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.repository.PassengerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PassengerEventServiceImpl implements PassengerEventService {

	private PassengerEventRepository passengerEventRepository;

	@Autowired
	public PassengerEventServiceImpl(PassengerEventRepository passengerEventRepository) {
		this.passengerEventRepository = passengerEventRepository;
	}

	@Transactional
	public PassengerEvent save(final PassengerEvent passengerEvent) {
		return this.passengerEventRepository.save(passengerEvent);
	}

	@Override
	public PassengerEvent findByEventId(String id) {
		return this.passengerEventRepository.findByEventId(id);
	}

	@Override
	public PassengerEvent findByUserId(Long userId) {
		return this.passengerEventRepository.findByUserId(userId);
	}

	@Override
	public List<PassengerEvent> save(List<PassengerEvent> passengerEvents) {
		return this.passengerEventRepository.saveAll(passengerEvents);
	}

}
