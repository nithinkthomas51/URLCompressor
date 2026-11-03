package com.nith.urlcompressor.handler;

import java.util.Optional;

public interface RedirectHandler {
	
	Optional<String> resolve(String shortCode);

}
