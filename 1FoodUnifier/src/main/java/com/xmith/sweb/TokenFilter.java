package com.xmith.sweb;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class TokenFilter extends GenericFilterBean{
	
	private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
	private TokenGenerator generator;

	public TokenFilter(TokenGenerator generator) {
		// TODO Auto-generated constructor stub
		this.generator=generator;
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
HttpServletRequest httprequest=(HttpServletRequest)request;		
HttpServletResponse httpresponse=(HttpServletResponse)response;

StringBuffer requestURL = httprequest.getRequestURL();
if(requestURL.toString().contains("secure")){
try{
String aheader=httprequest.getHeader("Authorization");
if(!aheader.isEmpty()){
	if(this.generator.validateToken(aheader)){
		Authentication authentication=this.generator.getauthenticated(aheader);
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		logger.info("security context");
		//proper
		chain.doFilter(httprequest, httpresponse);	
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	else{
		logger.info("token validation error");
		httpresponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}	
}

else{
	logger.info("header empty");
	httpresponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
}
}
catch (Exception e){
e.printStackTrace();
httpresponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
}
}
else{
chain.doFilter(httprequest, httpresponse);	
SecurityContextHolder.getContext().setAuthentication(null);
}
	
	
}
	
}