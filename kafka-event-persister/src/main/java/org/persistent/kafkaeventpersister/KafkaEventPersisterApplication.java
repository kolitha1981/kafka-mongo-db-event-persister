package org.persistent.kafkaeventpersister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.persistent.kafkaeventpersister"})
public class KafkaEventPersisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaEventPersisterApplication.class, args);
	}

}
