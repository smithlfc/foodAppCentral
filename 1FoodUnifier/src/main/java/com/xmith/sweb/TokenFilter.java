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
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requestu=(HttpServletRequest) request1;
		StringBuffer requestURL = requestu.getRequestURL();
		if(requestURL.toString().contains("secure")){

			// TODO Auto-generated method stub
			try{
				HttpServletRequest request=(HttpServletRequest) request1;
				HttpServletResponse response=(HttpServletResponse) response1;
				String aheader=request.getHeader("Authorization");
				if(!aheader.isEmpty()){
					if(this.generator.validateToken(aheader)){
						Authentication authentication=this.generator.getauthenticated(aheader);
						SecurityContextHolder.getContext().setAuthentication(authentication);
						logger.info("security context");
					}
					else{
						logger.info("token validation error");
					}
				}
				else{
					logger.info("header empty");
				}
				chain.doFilter(request1, response1);
				SecurityContextHolder.getContext().setAuthentication(null);
				
			}
			catch(Exception e){
				
				logger.info("token auth problem");
				((HttpServletResponse) response1).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
			
		
		}
		else{
			chain.doFilter(request1, response1);
		}
		
		
		
		
	}
	
	
	
}