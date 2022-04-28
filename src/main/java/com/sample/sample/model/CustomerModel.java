package com.sample.sample.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerModel {

	private String customerid;
	private String custFirstName;
	private String custLastName;
	private String custStreetAddress;
	private String custCity;
	private String custState;
	private String custZipCode;
	private String custAreaCode;
	private String custPhoneNumber;
	
}
