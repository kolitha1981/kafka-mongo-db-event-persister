package org.persistent.kafkaeventpersister.repository;

import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PassengerEventRepository extends MongoRepository<PassengerEvent, String>{

	 @Query("{ 'userId' : ?0 }")
     PassengerEvent findByUserId(Long userId);
	 
	 @Query("{ 'passengerId' : ?0 }")
	 PassengerEvent findByEventId(String passengerId);
}
