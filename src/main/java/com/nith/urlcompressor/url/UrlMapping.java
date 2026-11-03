package com.nith.urlcompressor.url;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UrlMapping {
	
	@Id
	@Column(length = 10)
	String shortCode;
	
	@Column(nullable = false, length = 2048)
	String longUrl;
	
	@Column
	Instant createdAt;
	
	UrlMapping() {}
	
	UrlMapping(String shortCode, String longUrl, Instant createdAt) {
		this.shortCode = shortCode;
		this.longUrl = longUrl;
		this.createdAt = createdAt;
		
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

}
