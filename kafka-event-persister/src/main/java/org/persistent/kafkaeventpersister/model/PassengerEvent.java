package org.persistent.kafkaeventpersister.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passengerevents")
public class PassengerEvent {
	
	@Id
	private String passengerId;
	private String eventType;
	private Long userId;
    private Date createdOn;
    private String createdBy;
    
    public PassengerEvent()
    {
    	
    }
    
	public PassengerEvent(String eventType, Long userId, Date createdOn, String createdBy) {
		super();
		this.eventType = eventType;
		this.userId = userId;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getEventType() {
		return eventType;
	}

	public Long getUserId() {
		return userId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerEvent other = (PassengerEvent) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}	

}
