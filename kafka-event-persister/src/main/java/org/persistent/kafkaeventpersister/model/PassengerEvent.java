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
		return 31 * (((createdOn == null) ? 0 : createdOn.hashCode()) + 31) + ((userId == null) ? 0 : userId.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || getClass() != obj.getClass())
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
