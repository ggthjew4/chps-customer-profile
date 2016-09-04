package com.chc.chps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This CustomerProfileNotFoundException is for Spring RESTful service
 * @author kerrigan
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This customer profile is not found in the system")
public class CustomerProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2545750253835111200L;

}
