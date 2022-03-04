package com.zensar.controller;

import java.security.Principal;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//oAuth2 Demo
@RestController
public class JobPortalController {
	
		@GetMapping("/")
		public String getMessage(Principal principal) {
			
			OAuth2AuthenticationToken oAuthToken = (OAuth2AuthenticationToken) principal;
			String loginName = oAuthToken.getPrincipal().getAttribute("login");
			return "Hello "+loginName;
		}
}
