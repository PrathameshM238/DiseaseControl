package com.example.demo.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="test_type")
public class TestType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	
	@Column(name="test_type_def")
	private String test_type_def;
	
	@OneToOne(mappedBy = "testTypeDetails")
	private TestModel test;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTest_type_def() {
		return test_type_def;
	}


	public void setTest_type_def(String test_type_def) {
		this.test_type_def = test_type_def;
	}


	public TestModel getTest() {
		return test;
	}


	public void setTest(TestModel test) {
		this.test = test;
	}
	
	
	
	
	

}
