package com.samdo.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.samdo.demo.dto.RequestObject;
import com.samdo.demo.dto.SampleResponse;

@Service
public class DemoService extends ExecutorService {
	@Value("${baseUrl}")
	private String baseUrl;
	public SampleResponse callSampleApi() {

		RequestObject requestObject = new RequestObject();
		requestObject.setUrl(baseUrl + "/todos/1");
		requestObject.setMethod(HttpMethod.GET);
		ResponseEntity<SampleResponse> response = callExternalApi(requestObject, SampleResponse.class);
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody();
		}
		
		return null;
	}
	
	public SampleResponse callSampleApiWithFeign() {
	    JsonPlaceHolderClient bookClient = JsonPlaceHolderBuilder.createClient(JsonPlaceHolderClient.class, baseUrl);

	    return bookClient.findById("1");
	}
}
