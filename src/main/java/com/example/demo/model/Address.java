package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name="address")
@JsonIgnoreProperties
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="location")
	private String location;
	
	@Column(name= "pin_code")
	private String pinCode;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="id")
	 * 
	 * @JsonIgnoreProperties("id")
	 */
	@ManyToMany(mappedBy = "addresses")
    @JsonIgnoreProperties("addresses")
    private Set<AnimalGroup> animalGroups;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Set<AnimalGroup> getAnimalGroups() {
		return animalGroups;
	}

	public void setAnimalGroups(Set<AnimalGroup> animalGroups) {
		this.animalGroups = animalGroups;
	}
	
	

}
