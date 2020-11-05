package org.persistent.kafkaeventpersister.controller;

import org.persistent.kafkaeventpersister.model.PassengerEvent;
import org.persistent.kafkaeventpersister.service.PassengerEventService;
import org.sltb.transportmanagement.core.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PassengerEventController {

	@Autowired
	private PassengerEventService passengerEventService;

	@RequestMapping(method = {
			RequestMethod.POST }, path = "/passengerevents", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse create(@RequestBody PassengerEvent passengerEvent) {
		PassengerEvent savedEvent;
		try {
			savedEvent = passengerEventService.save(passengerEvent);

		} catch (Exception e) {
			return new WebResponse.WebResponseBuilder<PassengerEvent>().addResponseData(null)
					.addResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()).addMessage(e.getMessage()).build();
		}
		return new WebResponse.WebResponseBuilder<PassengerEvent>().addResponseData(savedEvent)
				.addResponseStatus(HttpStatus.OK.value()).addMessage("").build();
	}

	@RequestMapping(method = {
			RequestMethod.GET }, path = "/passengerevents/${eventId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse getByEventId(@PathVariable("eventId") String eventId) {
		PassengerEvent passengerEvent;
		try {
			passengerEvent = passengerEventService.findByEventId(eventId);

		} catch (Exception e) {
			return new WebResponse.WebResponseBuilder<PassengerEvent>().addResponseData(null)
					.addResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()).addMessage(e.getMessage()).build();
		}
		return new WebResponse.WebResponseBuilder<PassengerEvent>().addResponseData(passengerEvent)
				.addResponseStatus(HttpStatus.OK.value()).addMessage("").build();
	}

	@RequestMapping(method = {
			RequestMethod.GET }, path = "/passengerevents/${userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse getUserId(@PathVariable("userId") long userId) {
		PassengerEvent passengerEvent;
		try {
			passengerEvent = passengerEventService.findByUserId(userId);

		} catch (Exception e) {
			return new WebResponse.WebResponseBuilder<PassengerEvent>().addResponseData(null)
					.addResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()).addMessage(e.getMessage()).build();
		}
		return new WebResponse.WebResponseBuilder<PassengerEvent>().addResponseData(passengerEvent)
				.addResponseStatus(HttpStatus.OK.value()).addMessage("").build();
	}

}
