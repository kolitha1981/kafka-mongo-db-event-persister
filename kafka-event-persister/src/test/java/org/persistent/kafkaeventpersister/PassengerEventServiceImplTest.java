package org.persistent.kafkaeventpersister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.repository.PassengerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class PassengerEventServiceImplTest {
	@Autowired
	private PassengerEventRepository passengerEventRepository;

	@Test
	public void testSavePassengerEvent() {
		final PassengerEvent passengerEvent = new PassengerEvent("CREATE-JOURNEY", 1L, Calendar.getInstance().getTime(),
				"admin"), savedEvent = passengerEventRepository.save(passengerEvent);
		assertNotNull(savedEvent);
		assertNotNull(savedEvent.getPassengerId());
	}

	@Test
	public void testGetEventByPassengerId() {
		final PassengerEvent passengerEvent = new PassengerEvent("CREATE-JOURNEY", 2L, Calendar.getInstance().getTime(),
				"admin"), savedEvent = passengerEventRepository.save(passengerEvent);
		assertNotNull(savedEvent);
		assertNotNull(savedEvent.getPassengerId());
		final PassengerEvent retrievedEvent = passengerEventRepository.findByEventId(savedEvent.getPassengerId());
		assertNotNull(retrievedEvent);
		assertNotNull(retrievedEvent.getPassengerId());
		assertEquals(savedEvent.getPassengerId(), retrievedEvent.getPassengerId());
	}

	@Test
	public void testGetEventByUserId() {
		final PassengerEvent passengerEvent = new PassengerEvent("CREATE-JOURNEY", 3L, Calendar.getInstance().getTime(),
				"admin"), savedEvent = passengerEventRepository.save(passengerEvent);
		assertNotNull(savedEvent);
		assertNotNull(savedEvent.getPassengerId());
		final PassengerEvent retrievedEvent = passengerEventRepository.findByEventId(savedEvent.getPassengerId());
		assertNotNull(retrievedEvent);
		assertNotNull(retrievedEvent.getPassengerId());
		assertEquals(savedEvent.getPassengerId(), retrievedEvent.getPassengerId());
	}
}
