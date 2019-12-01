package com.samdo.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samdo.demo.dto.SampleResponse;
import com.samdo.demo.service.DemoService;

@RestController
@RequestMapping(value = "/api/v1/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@GetMapping(value = "/fetch")
	public ResponseEntity<SampleResponse> callApi(@RequestBody Map<String, String> data) {
		return new ResponseEntity<SampleResponse>(demoService.callSampleApi(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/fetch/using-feign")
	public ResponseEntity<SampleResponse> callApiUsingFeign() {
		return new ResponseEntity<SampleResponse>(demoService.callSampleApiWithFeign(), HttpStatus.OK);
	}
}
