package org.persistent.kafkaeventpersister.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PassengerEvent {
	
	@Id
	private String passengerId;

}
