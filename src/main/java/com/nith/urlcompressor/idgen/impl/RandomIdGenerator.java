package com.nith.urlcompressor.idgen.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.nith.urlcompressor.idgen.IdGenerator;

@Component
@ConditionalOnProperty(name = "app.id.generator", havingValue = "random")
public class RandomIdGenerator implements IdGenerator {

	@Override
	public BigInteger generateId(int length) {
		
		int bits = (int) Math.ceil(length * 6.0);
		byte[] buf = new byte[(bits + 7) / 8];
		SecureRandom RNG = new SecureRandom();
		RNG.nextBytes(buf);
		return new BigInteger(1, buf);
	}

}
