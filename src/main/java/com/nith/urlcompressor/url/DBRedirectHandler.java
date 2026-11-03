package com.nith.urlcompressor.url;

import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.nith.urlcompressor.handler.RedirectHandler;

@Component
@ConditionalOnProperty(name = "app.redirect.handler", havingValue = "db", matchIfMissing = true)
public class DBRedirectHandler implements RedirectHandler {
	
	private final UrlService service;
	
	DBRedirectHandler(UrlService service) {
		this.service = service;
	}

	@Override
	public Optional<String> resolve(String shortCode) {
		return service.getLongUrl(shortCode);
	}

}
