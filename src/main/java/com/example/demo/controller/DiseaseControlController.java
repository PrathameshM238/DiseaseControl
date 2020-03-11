package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Test;
import com.example.demo.service.DiseaseControlBM;

@RestController
public class DiseaseControlController {
	@Autowired
	DiseaseControlBM dcBm;
	
	@Autowired
	Test testTo;
   
	@RequestMapping(value="/create-test", method=RequestMethod.POST)
	public void createTest(@RequestBody Test test) {
		dcBm.createTest(test);
//		return ResponseEntity.ok().body(200);
	}
	
	@RequestMapping(value="/test/{test-id}")
	public Test getTest(@PathVariable("test-id") Integer testId){
		return testTo.map(dcBm.getTestInfo(testId).orElseThrow(()-> new IllegalArgumentException("Test id not found")));
	}
}
