package com.test.POJO;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class AddResponseEmployeePOJO {
	



	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"status",
	"data",
	"message"
	})

	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private AddDataResponsePOJO data;
	@JsonProperty("message")
	private String message;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("status")
	public String getStatus() {
	return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
	this.status = status;
	}

	@JsonProperty("data")
	public AddDataResponsePOJO getData() {
	return data;
	}

	@JsonProperty("data")
	public void setData(AddDataResponsePOJO data) {
	this.data = data;
	}

	@JsonProperty("message")
	public String getMessage() {
	return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
	this.message = message;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	}


