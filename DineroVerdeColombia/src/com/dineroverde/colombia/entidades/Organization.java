package com.dineroverde.colombia.entidades;

public class Organization {

	
	private int organizationID;
	private String nationalID;
	private String name;
	private String website;
	private String description;
	private int countryID;

	public Organization(final int pOrganizationID, final String pNationalID,
			final String pName, final String pWebsite,
			final String pDescription, final int pCountriID) {
		organizationID = pOrganizationID;
		nationalID = pNationalID;
		name = pName;
		website = pWebsite;
		description = pDescription;
		countryID = pCountriID;
	}
	public int getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCountryID() {
		return countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}


}
