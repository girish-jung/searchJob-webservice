package com.swipejobs.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.swipejobs.utils.JsonDateSerializer;

/**
 * 
 * @author Girish Jung
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
	"driverLicenseRequired",
	"requiredCertificates",
	"location",
	"billRate",
	"workersRequired",
	"startDate",
	"about",
	"jobTitle",
	"company",
	"guid",
	"jobId"
})
public class Job {

	@JsonProperty("driverLicenseRequired")
	private Boolean driverLicenseRequired;
	
	@JsonProperty("requiredCertificates")
	private List<String> requiredCertificates = new ArrayList<String>();
	
	@JsonProperty("location")
	private Location location;
	
	@JsonProperty("billRate")
	private String billRate;
	
	@JsonProperty("workersRequired")
	private Integer workersRequired;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonProperty("startDate")
	private Date startDate;
	
	@JsonProperty("about")
	private String about;
	
	@JsonProperty("jobTitle")
	private String jobTitle;
	
	@JsonProperty("company")
	private String company;
	
	@JsonProperty("guid")
	private String guid;
	
	@JsonProperty("jobId")
	private Integer jobId;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return
	 *     The driverLicenseRequired
	 */
	@JsonProperty("driverLicenseRequired")
	public Boolean getDriverLicenseRequired() {
		return driverLicenseRequired;
	}

	/**
	 * 
	 * @param driverLicenseRequired
	 *     The driverLicenseRequired
	 */
	@JsonProperty("driverLicenseRequired")
	public void setDriverLicenseRequired(Boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}

	/**
	 * 
	 * @return
	 *     The requiredCertificates
	 */
	@JsonProperty("requiredCertificates")
	public List<String> getRequiredCertificates() {
		return requiredCertificates;
	}

	/**
	 * 
	 * @param requiredCertificates
	 *     The requiredCertificates
	 */
	@JsonProperty("requiredCertificates")
	public void setRequiredCertificates(List<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	/**
	 * 
	 * @return
	 *     The location
	 */
	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 *     The location
	 */
	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * 
	 * @return
	 *     The billRate
	 */
	@JsonProperty("billRate")
	public String getBillRate() {
		return billRate;
	}

	/**
	 * 
	 * @param billRate
	 *     The billRate
	 */
	@JsonProperty("billRate")
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	/**
	 * 
	 * @return
	 *     The workersRequired
	 */
	@JsonProperty("workersRequired")
	public Integer getWorkersRequired() {
		return workersRequired;
	}

	/**
	 * 
	 * @param workersRequired
	 *     The workersRequired
	 */
	@JsonProperty("workersRequired")
	public void setWorkersRequired(Integer workersRequired) {
		this.workersRequired = workersRequired;
	}

	/**
	 * 
	 * @return
	 *     The startDate
	 */
	@JsonProperty("startDate")
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 *     The startDate
	 */
	@JsonProperty("startDate")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return
	 *     The about
	 */
	@JsonProperty("about")
	public String getAbout() {
		return about;
	}

	/**
	 * 
	 * @param about
	 *     The about
	 */
	@JsonProperty("about")
	public void setAbout(String about) {
		this.about = about;
	}

	/**
	 * 
	 * @return
	 *     The jobTitle
	 */
	@JsonProperty("jobTitle")
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * 
	 * @param jobTitle
	 *     The jobTitle
	 */
	@JsonProperty("jobTitle")
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * 
	 * @return
	 *     The company
	 */
	@JsonProperty("company")
	public String getCompany() {
		return company;
	}

	/**
	 * 
	 * @param company
	 *     The company
	 */
	@JsonProperty("company")
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 
	 * @return
	 *     The guid
	 */
	@JsonProperty("guid")
	public String getGuid() {
		return guid;
	}

	/**
	 * 
	 * @param guid
	 *     The guid
	 */
	@JsonProperty("guid")
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * 
	 * @return
	 *     The jobId
	 */
	@JsonProperty("jobId")
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * 
	 * @param jobId
	 *     The jobId
	 */
	@JsonProperty("jobId")
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	@JsonIgnore
	public Double getWageRate() {
		final NumberFormat format = NumberFormat.getNumberInstance();
		try {
			return (Double) format.parse(this.billRate.replaceAll("[^\\d.,]",""));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

