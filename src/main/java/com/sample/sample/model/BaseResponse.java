package com.sample.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"stat" ,"err" ,"desc" })
@Setter
@Getter
public class BaseResponse {

	    @JsonProperty("stat")
	    private String stat = "ok";

	    @JsonProperty("err")
	    private ErrorResponse err;

	    @JsonProperty("data")
	    private Object data;

	    public BaseResponse() {}

	    public BaseResponse(Object data) {
	        this.data = data;
	    }
	
}
