package com.mytectra.learning.bookourshow.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Inactive;

@JsonInclude(value = Include.NON_EMPTY)
public class ResponseWrapper<T> {
	
	private T response;
	
	public enum  Status {SUCCESS , INVALID_REQUEST , ERROR}; 
	
	private Status status;
	

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


}
