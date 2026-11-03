package com.nith.urlcompressor.url;

public class UrlRequestDto {
	
	String longUrl;
	
	public UrlRequestDto(String longUrl) {
		this.longUrl = longUrl;
	}
	
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	public String getLongUrl() {
		return longUrl;
	}

}
