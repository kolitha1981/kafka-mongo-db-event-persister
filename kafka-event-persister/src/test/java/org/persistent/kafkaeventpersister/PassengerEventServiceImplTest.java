package org.persistent.kafkaeventpersister;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.repository.PassengerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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

}
