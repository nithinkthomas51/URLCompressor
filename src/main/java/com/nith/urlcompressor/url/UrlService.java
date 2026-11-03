package com.nith.urlcompressor.url;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Optional;

//import java.time.Instant;

import org.springframework.stereotype.Service;

import com.nith.urlcompressor.idencoder.IdEncoder;
import com.nith.urlcompressor.idgen.IdGenerator;

@Service
public class UrlService {
	
	private final IdGenerator idGenerator;
	private final IdEncoder idEncoder;
	private final UrlRepository repository;
	
	UrlService(IdGenerator idGenerator, IdEncoder idEncoder, UrlRepository repository) {
		this.idGenerator = idGenerator;
		this.idEncoder = idEncoder;
		this.repository = repository;
	}
	
	UrlResponseDto createUrl(UrlRequestDto request) {
		
		BigInteger uniqueId = idGenerator.generateId(7);
		String shortCode = idEncoder.encode(uniqueId);
		
		while (repository.existsByShortCode(shortCode)) {
			uniqueId = idGenerator.generateId(7);
			shortCode = idEncoder.encode(uniqueId);
		}
		UrlMapping savedUrlMapping = repository.save(new UrlMapping(shortCode, request.longUrl, Instant.now()));
		return new UrlResponseDto(savedUrlMapping.shortCode);
	}
	
	Optional<String> getLongUrl(String shortCode) {
		return repository.findByShortCode(shortCode)
				.map(UrlMapping::getLongUrl);
	}

}
