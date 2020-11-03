package org.perisstent.publisher.kafkaeventpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaEventPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaEventPublisherApplication.class, args);
	}

}
