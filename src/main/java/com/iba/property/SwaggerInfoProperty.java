package com.iba.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwaggerInfoProperty {
	
	@Value("${api.swagger.info.title}")
	private String title;
	
	@Value("${api.swagger.info.description}")
	private String description;
	
	@Value("${api.swagger.info.version}")
	private String version;
	
	@Value("${api.swagger.info.terms-of-service-url}")
	private String termsOfServiceUrl;
	
	@Value("${api.swagger.info.license}")
	private String license;
	
	@Value("${api.swagger.info.license-url}")
	private String licenseUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

}
