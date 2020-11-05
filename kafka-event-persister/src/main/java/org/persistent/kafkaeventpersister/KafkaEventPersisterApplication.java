package org.persistent.kafkaeventpersister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "org.persistent.kafkaeventpersister" })
@SpringBootApplication
public class KafkaEventPersisterApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaEventPersisterApplication.class, args);
	}
}
