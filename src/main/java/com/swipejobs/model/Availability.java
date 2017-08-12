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
@JsonPropertyOrder({"title", "dayIndex"})
public class Availability {

	@JsonProperty("title")
	private String title;
	@JsonProperty("dayIndex")
	private Integer dayIndex;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return
	 * The title
	 */
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 * The title
	 */
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return
	 * The dayIndex
	 */
	@JsonProperty("dayIndex")
	public Integer getDayIndex() {
		return dayIndex;
	}

	/**
	 * 
	 * @param dayIndex
	 * The dayIndex
	 */
	@JsonProperty("dayIndex")
	public void setDayIndex(Integer dayIndex) {
		this.dayIndex = dayIndex;
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
