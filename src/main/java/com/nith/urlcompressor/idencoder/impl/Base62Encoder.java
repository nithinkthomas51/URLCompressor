package com.nith.urlcompressor.idencoder.impl;

import java.math.BigInteger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.nith.urlcompressor.idencoder.IdEncoder;

@Component
@ConditionalOnProperty(name = "app.id.encoder", havingValue = "base62", matchIfMissing = true)
public class Base62Encoder implements IdEncoder {
	
	private final char[] ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	@Override
	public String encode(BigInteger id) {
		
		if (id.signum() == 0) return "0";
		StringBuilder sb = new StringBuilder();
		BigInteger radix = BigInteger.valueOf(ALPHABET.length);
		while (id.signum() > 0) {
			BigInteger[] divRem = id.divideAndRemainder(radix);
			sb.append(ALPHABET[divRem[1].intValue()]);
			id = divRem[0];
		}
		return sb.reverse().toString().substring(0, 7);
	}

}
