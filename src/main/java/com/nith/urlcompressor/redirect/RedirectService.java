package com.nith.urlcompressor.redirect;

import org.springframework.stereotype.Service;

import com.nith.urlcompressor.exception.ShortCodeNotFoundException;
import com.nith.urlcompressor.handler.RedirectHandler;

@Service
public class RedirectService {
	
	private final RedirectHandler redirectHandler;
	
	public RedirectService(RedirectHandler redirectHandler) {
		this.redirectHandler = redirectHandler;
	}
	
	public String redirect(String shortCode) {
		return redirectHandler.resolve(shortCode)
				.orElseThrow(()->new ShortCodeNotFoundException(shortCode));
	}

}
