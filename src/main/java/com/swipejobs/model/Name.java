package com.swipejobs.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "last", "first" })
public class Name {

	@JsonProperty("last")
	private String last;
	@JsonProperty("first")
	private String first;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return
	 * The last
	 */
	@JsonProperty("last")
	public String getLast() {
		return last;
	}

	/**
	 * 
	 * @param last
	 * The last
	 */
	@JsonProperty("last")
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * 
	 * @return
	 * The first
	 */
	@JsonProperty("first")
	public String getFirst() {
		return first;
	}

	/**
	 * 
	 * @param first
	 * The first
	 */
	@JsonProperty("first")
	public void setFirst(String first) {
		this.first = first;
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
