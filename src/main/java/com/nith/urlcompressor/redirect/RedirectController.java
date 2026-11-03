package com.nith.urlcompressor.redirect;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RedirectController {
	
	private final RedirectService service;
	
	public RedirectController(RedirectService service) {
		this.service = service;
	}
	
	@GetMapping("{shortCode}")
	public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
		String longUrl = service.redirect(shortCode);
		return ResponseEntity
				.status(HttpStatus.MOVED_PERMANENTLY)
				.location(URI.create(longUrl))
				.build();
	}

}
