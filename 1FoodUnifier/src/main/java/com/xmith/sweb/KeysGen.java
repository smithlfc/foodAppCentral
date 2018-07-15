package com.xmith.sweb;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KeysGen  {
	
	private static final Logger logger = LoggerFactory.getLogger(KeysGen.class);

	
	static PrivateKey private1;
	static PublicKey public1;
	


	

	static {
		try {
			KeyPairGenerator generator= KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			
			KeyPair generatedKeyPair = generator.generateKeyPair();
			
			 private1 = generatedKeyPair.getPrivate();
			 public1 = generatedKeyPair.getPublic();
			logger.info("***keys generated****");
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
	}

	

	

}
