package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.bean.AnimalGroupTO;
import com.example.demo.bean.Test;
import com.example.demo.dao.SQLServerAnimalGroupDAO;
import com.example.demo.dao.SQLServerTestType;
import com.example.demo.dao.SQLSeverTestDAO;
import com.example.demo.model.AnimalGroup;
import com.example.demo.model.TestModel;
import com.example.demo.model.TestType;

@Service
public class DiseaseControlBM {

		@Autowired
		TestModel testModel;
		
		@Autowired
		TestType typeModel;
		
		@Autowired
		SQLSeverTestDAO testDao;
		
		@Autowired
		SQLServerAnimalGroupDAO agDao;
		
		@Autowired
		SQLServerTestType typeDao;
		
		@Autowired
		AnimalGroup agModel;
		
		@Autowired
	    RestTemplate restTemplate;
		
		
		
		    		
		public Optional<TestModel> getTestInfo(Integer testId) {
			return testDao.findById(testId);
		
		}
		
		public List<TestModel> getAllTest(List<Integer> testIds){
			return testDao.findAllById(testIds);
		}
		
		public void createTest(Test test) {
			typeModel.setTest_type_def(test.getTestType());
			//typeModel=typeDao.save(typeModel);
			testModel.setTestStatus(test.getTestStatus());
			typeModel.setTest(testModel);
			testModel.setTestTypeDetails(typeModel);
			HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", "application/json");
	        String uri = "http://animal-group-registration/get-animal-group-details/" + test.getAnimalGroupNumber();
	        UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri).build();
	        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
	        ResponseEntity<AnimalGroupTO> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AnimalGroupTO.class);
			agModel= AnimalGroupTO.mapModel(responseEntity.getBody());
		    testModel.setFk_AnimalGroup(agModel);
		    testDao.save(testModel);
		}


	}

