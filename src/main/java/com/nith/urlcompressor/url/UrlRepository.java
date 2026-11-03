package com.nith.urlcompressor.url;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlMapping, String> {
	
	boolean existsByShortCode(String shortCode);
	Optional<UrlMapping> findByShortCode(String shortCode);

}
