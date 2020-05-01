package com.sample.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"code", "message"})
@Getter
@Setter
public class ErrorResponse {
	   
	    @JsonProperty("code")
	    public String code;

	    @JsonProperty("msg")
	    public String message;
}
