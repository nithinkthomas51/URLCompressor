package com.nith.urlcompressor.url;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class UrlController {
	
	private final UrlService service;
	
	UrlController(UrlService service) {
		this.service = service;
	}
	
	@PostMapping
	ResponseEntity<UrlResponseDto> createUrl(@Valid @RequestBody UrlRequestDto request) {
		UrlResponseDto res = service.createUrl(request);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(res);
	}

}
