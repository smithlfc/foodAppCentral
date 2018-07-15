package com.xmith.sweb;

import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.hibernate.property.access.spi.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.xmith.models.Users;
import com.xmith.services.UserServices;
import com.xmith.services.UserServicesImpl;


public class TokenGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);
	
	
	@Autowired
    private UserServices uservices;
    public void setUservices(UserServices uservices) {
		this.uservices = uservices;
	}

	
	public String generateToken(String userName){
		logger.info("generateToken entry");
		JWSHeader header= new JWSHeader(JWSAlgorithm.RS256);
		logger.info("header cdreated ");
		
		
		
	
		
		Random random= new Random();
		int low=1;
		int high=1000;
		int jwtID=random.nextInt(high-low)+low;
		
		logger.info("jwt id  generated");
		
		
		//todo
		//get use from db
		
	//	logger.info("value from db **********"+uservices.getUserId("max"));
		
	//	logger.info("user name from db is "+userServices.getUserId("sdsd"));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String lname=authentication.getName();
		
		JWTClaimsSet claimsSet=new JWTClaimsSet.Builder()
			               .issuer("max").audience("all").jwtID(""+jwtID)
			               .expirationTime(new Date(new Date().getTime()*(60*5000)))
			               .claim("userid", uservices.getUserId(lname)).build();
		//update token id in table with logged in name
		
		logger.info("token updating");
		uservices.updateTokenService(lname, jwtID+"");
		logger.info("token updated");
		//token updated
		
	   logger.info("generated claims");
		
	   //satic variable
	   
	
	   if(KeysGen.private1==null){
		  logger.info("rsa private  null reterived"); 
	   }
	  
	   
	   RSASSASigner signer= new RSASSASigner((RSAPrivateKey)KeysGen.private1);
	   SignedJWT signedpayload= new SignedJWT(header, claimsSet);
	   try {
		signedpayload.sign(signer);
		
		
	} catch (JOSEException e) {
		
		e.printStackTrace();
	}
	   
	 String token= signedpayload.serialize();
	 logger.info("token is :"+token);
		
		
		
		logger.info("generate token exit");
		
		return token;
	}
	
	//validate token
	
	public boolean validateToken(String token){
		logger.info("validateToken entry");
		if(!token.isEmpty()){
			logger.info("token is not empty");
			String temp[]=token.split("\\.");
			logger.info("after split: "+temp.length);
			
			Base64URL header= new Base64URL(temp[0]);
			Base64URL payload=new Base64URL(temp[1]);
			Base64URL signature=new Base64URL(temp[2]);
			
			try {
				SignedJWT signedJWT= new SignedJWT(header, payload, signature);
				JWSVerifier signatureverifier=new RSASSAVerifier((RSAPublicKey)KeysGen.public1);
				if(signedJWT.verify(signatureverifier)){
					logger.info("signature verified");
					
					return true;
				}
				else{
					logger.info("problem in verifing signature");
					return false;
				}
				
			} catch (ParseException | JOSEException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		else{
			logger.info("token is empty");
		}
		
		logger.info("validateToken: code sholdnt reach here :Exit");
		return false;
	}
	
	
	//auth token
	
	public Authentication getauthenticated(String token){
		
		logger.info("getauthenticated Entry");
	
		if(!token.isEmpty()){
			String temp[]=token.split("\\.");
			logger.info("after split..: "+temp.length);
		    Base64URL header= new Base64URL(temp[0]);
			Base64URL payload=new Base64URL(temp[1]);
			Base64URL signature=new Base64URL(temp[2]);
			try {
				SignedJWT signedJWT= new SignedJWT(header, payload, signature);
				JWTClaimsSet jwtClaimsSet = signedJWT.getJWTClaimsSet();
				//get name,id,token with id
				
				Users tempusers=uservices.getuserService(""+jwtClaimsSet.getClaim("userid"));
				//compare if match form authentication else null
		
				if(tempusers.getUser_token().equalsIgnoreCase(jwtClaimsSet.getJWTID())){
			      logger.info("token and claims validated");
			    
			      return new UsernamePasswordAuthenticationToken(tempusers.getUser_name(), "", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
				
				}
				else{
					logger.info("exception should be here for hard coded");
				}
				
					
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
		}
		
		else{
			logger.info("token is empty");
		}
		
		
		logger.info("getauthenticated Exit");
		return null;
	}
	
	
	

}
