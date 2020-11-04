package org.persistent.kafkaeventpersister.repository;

import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PassengerEventRepository extends MongoRepository<PassengerEvent, String>{

}
