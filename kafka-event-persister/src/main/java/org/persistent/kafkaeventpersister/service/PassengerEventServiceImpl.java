package org.persistent.kafkaeventpersister.service;

import java.util.List;

import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.repository.PassengerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PassengerEventServiceImpl implements PassengerEventService {

	@Autowired
	private PassengerEventRepository passengerEventRepository;

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
	public boolean save(List<PassengerEvent> passengerEvents) {
		try {
			this.passengerEventRepository.saveAll(passengerEvents);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
