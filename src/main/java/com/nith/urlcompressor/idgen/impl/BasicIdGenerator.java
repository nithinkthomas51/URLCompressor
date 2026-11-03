package com.nith.urlcompressor.idgen.impl;

import java.math.BigInteger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.nith.urlcompressor.idgen.IdGenerator;

@Component
@ConditionalOnProperty(name = "app.id.generator", havingValue = "basic", matchIfMissing = true)
public class BasicIdGenerator implements IdGenerator {

	@Override
	public BigInteger generateId(int length) {
		System.out.println("Generating basic ID");
		return new BigInteger("0000000");
	}

}
