package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		public Optional<TestModel> getTestInfo(Integer testId) {
			return testDao.findById(testId);
		
		}
		
		public List<TestModel> getAllTest(List<Integer> testIds){
			return testDao.findAllById(testIds);
		}
		
		@Transactional
		public void createTest(Test test) {
			typeModel.setTest_type_def(test.getTestType());
			//typeModel=typeDao.save(typeModel);
			testModel.setTestStatus(test.getTestStatus());
			typeModel.setTest(testModel);
			testModel.setTestTypeDetails(typeModel);
			agModel=agDao.findByAnimalGroupNumber(test.getAnimalGroupNumber());
		    testModel.setFk_AnimalGroup(agModel);
		    testDao.save(testModel);
		}


	}

