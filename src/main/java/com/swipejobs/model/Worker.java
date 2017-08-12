package com.swipejobs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * 
 * @author Girish Jung
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
	"rating",
	"isActive",
	"certificates",
	"skills",
	"jobSearchAddress",
	"transportation",
	"hasDriversLicense",
	"availability",
	"phone",
	"email",
	"name",
	"age",
	"guid",
	"userId"
})
public class Worker {

	@JsonProperty("rating")
	private Integer rating;
	
	/**
	 * Flag stating whether a worker is actively searching for jobs or not.
	 */
	@JsonProperty("isActive")
	private Boolean isActive;
	
	@JsonProperty("certificates")
	private List<String> certificates = new ArrayList<String>();
	
	@JsonProperty("skills")
	private List<String> skills = new ArrayList<String>();
	
	@JsonProperty("jobSearchAddress")
	private JobSearchAddress jobSearchAddress;
	
	@JsonProperty("transportation")
	private String transportation;
	
	@JsonProperty("hasDriversLicense")
	private Boolean hasDriversLicense;
	
	@JsonProperty("availability")
	private List<Availability> availability = new ArrayList<Availability>();
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("name")
	private Name name;
	
	@JsonProperty("age")
	private Integer age;
	
	@JsonProperty("guid")
	private String guid;
	
	@JsonProperty("userId")
	private Integer userId;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return
	 * The rating
	 */
	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating
	 * The rating
	 */
	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * Returns true if the worker is actively searching for job. Else false.
	 * @return {@link Boolean}
	 */
	@JsonProperty("isActive")
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * 
	 * @param isActive
	 * The isActive
	 */
	@JsonProperty("isActive")
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return
	 * The certificates
	 */
	@JsonProperty("certificates")
	public List<String> getCertificates() {
		return certificates;
	}

	/**
	 * @param certificates
	 * The certificates
	 */
	@JsonProperty("certificates")
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}

	/**
	 * @return
	 * The skills
	 */
	@JsonProperty("skills")
	public List<String> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 * The skills
	 */
	@JsonProperty("skills")
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	/**
	 * @return
	 * The jobSearchAddress
	 */
	@JsonProperty("jobSearchAddress")
	public JobSearchAddress getJobSearchAddress() {
		return jobSearchAddress;
	}

	/**
	 * @param jobSearchAddress
	 * The jobSearchAddress
	 */
	@JsonProperty("jobSearchAddress")
	public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}

	/**
	 * @return
	 * The transportation
	 */
	@JsonProperty("transportation")
	public String getTransportation() {
		return transportation;
	}

	/**
	 * @param transportation
	 * The transportation
	 */
	@JsonProperty("transportation")
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	/**
	 * @return
	 * The hasDriversLicense
	 */
	@JsonProperty("hasDriversLicense")
	public Boolean getHasDriversLicense() {
		return hasDriversLicense;
	}

	/**
	 * @param hasDriversLicense
	 * The hasDriversLicense
	 */
	@JsonProperty("hasDriversLicense")
	public void setHasDriversLicense(Boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}

	/**
	 * @return
	 * The availability
	 */
	@JsonProperty("availability")
	public List<Availability> getAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 * The availability
	 */
	@JsonProperty("availability")
	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}

	/**
	 * @return
	 * The phone
	 */
	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 * The phone
	 */
	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return
	 * The email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 * The email
	 */
	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 * The name
	 */
	@JsonProperty("name")
	public Name getName() {
		return name;
	}

	/**
	 * @param name
	 * The name
	 */
	@JsonProperty("name")
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @return
	 * The age
	 */
	@JsonProperty("age")
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 * The age
	 */
	@JsonProperty("age")
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return
	 * The guid
	 */
	@JsonProperty("guid")
	public String getGuid() {
		return guid;
	}

	/**
	 * @param guid
	 * The guid
	 */
	@JsonProperty("guid")
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * @return
	 * The userId
	 */
	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 * The userId
	 */
	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
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
