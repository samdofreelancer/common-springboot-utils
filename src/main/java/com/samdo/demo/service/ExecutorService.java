package com.samdo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.samdo.demo.dto.RequestObject;

public abstract class ExecutorService {
	@Autowired
	private RestTemplate restTemplate;
	
    protected <T> ResponseEntity<T> callExternalApi(RequestObject requestObject, Class<T> clazz) {
    	
    	//headers
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    	//body
    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    	map.add("email", "first.last@example.com");

    	HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

    	return restTemplate.exchange(requestObject.getUrl(), requestObject.getMethod(), requestEntity, clazz);
    }
}
