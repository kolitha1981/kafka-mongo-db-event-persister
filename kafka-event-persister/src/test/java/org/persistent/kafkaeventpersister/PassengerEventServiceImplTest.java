package org.persistent.kafkaeventpersister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.repository.PassengerEventRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@DataMongoTest(excludeAutoConfiguration = { EmbeddedMongoAutoConfiguration.class })
@ExtendWith(SpringExtension.class)
class PassengerEventServiceImplTest {
	@Autowired
	private PassengerEventRepository passengerEventRepository;


	@Test
	public void testSavePassengerEvent() {
		final String passengerEventId = String.valueOf(1), eventType = "CREATE-JOURNEY";
		final Long userId = Long.valueOf(1);
		final Date createdOn = Calendar.getInstance().getTime();
		final String createdBy = "admin";
		final PassengerEvent passengerEvent = new PassengerEvent(passengerEventId, eventType, userId, createdOn,
				createdBy), savedEvent = passengerEventRepository.save(passengerEvent);
		assertNotNull(savedEvent);
		assertNotNull(savedEvent.getPassengerId());
		assertEquals(savedEvent.getPassengerId(), passengerEventId);
		assertNotNull(savedEvent.getUserId());
		assertEquals(savedEvent.getUserId(), userId);
		assertNotNull(savedEvent.getCreatedOn());
		assertEquals(savedEvent.getCreatedOn(), createdOn);
	}

	@Test
	public void testBulkSavePassengerEvent() {
		final List<PassengerEvent> passengerEvents = new ArrayList<PassengerEvent>();
		final String passengerEventId = String.valueOf(1), eventType = "CREATE-JOURNEY";
		final Long userId = Long.valueOf(1);
		final Date createdOn = Calendar.getInstance().getTime();
		final String createdBy = "admin";
		passengerEvents.add(new PassengerEvent(passengerEventId, eventType, userId, createdOn, createdBy));
		final String passengerEventId1 = String.valueOf(2);
		final Long userId1 = Long.valueOf(2);
		passengerEvents.add(new PassengerEvent(passengerEventId1, eventType, userId1, createdOn, createdBy));
		final String passengerEventId2 = String.valueOf(1);
		final Long userId2 = Long.valueOf(1);
		passengerEvents.add(new PassengerEvent(passengerEventId2, eventType, userId2, createdOn, createdBy));
		final String passengerEventId3 = String.valueOf(1);
		final Long userId3 = Long.valueOf(1);
		passengerEvents.add(new PassengerEvent(passengerEventId3, eventType, userId3, createdOn, createdBy));
		passengerEventRepository.saveAll(passengerEvents);
	}

	@Test
	public void testGetEventByPassengerId() {
		final PassengerEvent passengerEvent = new PassengerEvent("2", "CREATE-JOURNEY", 2L,
				Calendar.getInstance().getTime(), "admin"), savedEvent = passengerEventRepository.save(passengerEvent);
		assertNotNull(savedEvent);
		assertNotNull(savedEvent.getPassengerId());
		final PassengerEvent retrievedEvent = passengerEventRepository.findByEventId(savedEvent.getPassengerId());
		assertNotNull(retrievedEvent);
		assertNotNull(retrievedEvent.getPassengerId());
		assertEquals(savedEvent.getPassengerId(), retrievedEvent.getPassengerId());
	}

	@Test
	public void testGetEventByUserId() {
		final PassengerEvent passengerEvent = new PassengerEvent("3", "CREATE-JOURNEY", 3L,
				Calendar.getInstance().getTime(), "admin"), savedEvent = passengerEventRepository.save(passengerEvent);
		assertNotNull(savedEvent);
		assertNotNull(savedEvent.getPassengerId());
		final PassengerEvent retrievedEvent = passengerEventRepository.findByEventId(savedEvent.getPassengerId());
		assertNotNull(retrievedEvent);
		assertNotNull(retrievedEvent.getPassengerId());
		assertEquals(savedEvent.getPassengerId(), retrievedEvent.getPassengerId());
	}

	@Configuration
	static class MongoConfiguration implements InitializingBean, DisposableBean {
		MongodExecutable executable;
		@Value("${org.persistent.database.name}")
		private String databaseName;
		@Value("${org.persistent.database.server.name}")
		private String server;
		@Value("${org.persistent.database.server.port}")
		private int serverPort;

		@Override
		public void afterPropertiesSet() throws Exception {
			executable = MongodStarter.getDefaultInstance().prepare(new MongodConfigBuilder()
					.version(Version.Main.PRODUCTION).net(new Net(server, serverPort, Network.localhostIsIPv6())).build());
			executable.start();
		}

		@Bean
		public MongoRepositoryFactoryBean mongoFactoryRepositoryBean() {
			final MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
					.applyConnectionString(new ConnectionString("mongodb://localhost:27017/passengerevents"))
					.build());
			final MongoTemplate template = new MongoTemplate(mongoClient, "passengerevents");
			final MongoRepositoryFactoryBean mongoDbFactoryBean = new MongoRepositoryFactoryBean(
					PassengerEventRepository.class);
			mongoDbFactoryBean.setMongoOperations(template);
			return mongoDbFactoryBean;
		}

		@Override
		public void destroy() throws Exception {
			executable.stop();
		}
	}
}
