package com.cts.estock.jwtfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;


public class SecurityFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		String authHeader = httpReq.getHeader("authorization");
		
		if(authHeader == null || !authHeader.startsWith("Bearer")) {
			
			throw new ServletException("Missing or invalid authentication header");
			
		}
		
		String jwtToken = authHeader.substring(7); // eample = Bearer 78gtcds999cbchbhb8866csddv
		System.out.println("jwt Token: "+jwtToken);
		
//		Claims claim = Jwts.parser().setSigningKey("myKey").parseClaimsJws(jwtToken).getBody();
		
		httpReq.setAttribute("username", jwtToken);
		
		chain.doFilter(httpReq, httpRes);
		
	}

}
