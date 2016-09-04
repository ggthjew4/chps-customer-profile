package com.chc.chps.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * This CustomerNotFoundException is for Jersey RESTful service.
 * @author kerrigan
 */
public class CustomerNotFoundException extends WebApplicationException {

	private static final long serialVersionUID = 5257045362608108032L;

	  public CustomerNotFoundException() {
	    super(Response.Status.NOT_FOUND.getReasonPhrase());
	  }
	 
	  /**
	  * Create a HTTP 404 (Not Found) exception.
	  * @param message the String that is the entity of the 404 response.
	  */
	  public CustomerNotFoundException(String message) {
	    super(Response.status(Response.Status.NOT_FOUND).
	    entity(message).type("text/plain").build());
	  }

}
