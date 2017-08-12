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
@JsonPropertyOrder({
	"unit",
	"maxJobDistance",
	"longitude",
	"latitude"
})
public class JobSearchAddress {

	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("maxJobDistance")
	private Integer maxJobDistance;
	
	@JsonProperty("longitude")
	private Double longitude;
	
	@JsonProperty("latitude")
	private Double latitude;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return
	 * The unit
	 */
	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	/**
	 * 
	 * @param unit
	 * The unit
	 */
	@JsonProperty("unit")
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 
	 * @return
	 * The maxJobDistance
	 */
	@JsonProperty("maxJobDistance")
	public Integer getMaxJobDistance() {
		return maxJobDistance;
	}

	/**
	 * 
	 * @param maxJobDistance
	 * The maxJobDistance
	 */
	@JsonProperty("maxJobDistance")
	public void setMaxJobDistance(Integer maxJobDistance) {
		this.maxJobDistance = maxJobDistance;
	}

	/**
	 * 
	 * @return
	 * The longitude
	 */
	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude
	 * The longitude
	 */
	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return
	 * The latitude
	 */
	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 * The latitude
	 */
	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
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
