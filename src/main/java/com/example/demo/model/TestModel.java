package com.example.demo.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name="activity")
@Table(name="activity")
public class TestModel {
	public AnimalGroup getFk_AnimalGroup() {
		return fk_AnimalGroup;
	}
	public void setFk_AnimalGroup(AnimalGroup fk_AnimalGroup) {
		this.fk_AnimalGroup = fk_AnimalGroup;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="object_id",unique=true,nullable=false)
	private Integer testId;
	@Column(name="test_status")
	private String testStatus;
	
	@OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
	@JoinColumn(name="test_type")
	private TestType testTypeDetails;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_AnimalGroup")
	private AnimalGroup fk_AnimalGroup;
	
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
	public TestType getTestTypeDetails() {
		return testTypeDetails;
	}
	public void setTestTypeDetails(TestType testType) {
		this.testTypeDetails = testType;
	}
	
	
}
