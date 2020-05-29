package com.example.demo.bean;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.TestModel;


@Component
public class Test {
	private Integer testId;
	private String testStatus;
	private String testType;
	private String animalGroupNumber;
	

	@Autowired
	TestModel tm;
	
	@Autowired
	Test to;
	
	public Test map(TestModel testModal) {
		to.setTestId(testModal.getTestId());
		to.setTestStatus(testModal.getTestStatus());
		to.setTestType(testModal.getTestTypeDetails().getTest_type_def());
		to.setAnimalGroupNumber(testModal.getFk_AnimalGroup().getAnimalGroupNumber());
		return to;
		
	}
	
	public TestModel map(Test test) {
		TestModel tm=new TestModel();
		tm.setTestStatus(test.testStatus);
	  return tm;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	
	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getAnimalGroupNumber() {
		return animalGroupNumber;
	}

	public void setAnimalGroupNumber(String animalGroupNumber) {
		this.animalGroupNumber = animalGroupNumber;
	}
	
	

	
}
