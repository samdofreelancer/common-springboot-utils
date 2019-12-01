package com.samdo.demo.service;

import java.util.List;

import com.samdo.demo.dto.SampleResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface JsonPlaceHolderClient {
	@RequestLine("GET /todos/{id}")
	SampleResponse findById(@Param("id") String id);
	
	@RequestLine("GET")
    List<SampleResponse> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(SampleResponse sampleResponse);
}
