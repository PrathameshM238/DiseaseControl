package com.example.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Component
@Entity
@Table(name="animal_group")
public class AnimalGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="animalGroupNumber")
	private String animalGroupNumber;

	
	@Column(name="type")
	private String agType;
	
	public AnimalGroup() {
		this.agType="O-FARM";
	}
	
	@OneToMany(mappedBy = "fk_AnimalGroup")
	private List<TestModel> test;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinColumns({@JoinColumn(name="fk_animalGroup_id"),@JoinColumn(name="fk_address_id")})
	    /*
	     * @JoinTable( name = "AnimalGroup_Addresses", joinColumns = { @JoinColumn(name
	     * = "fk_animalGroup_id") }, inverseJoinColumns = { @JoinColumn(name =
	     * "fk_address_id") } )
	     */
	     @JsonIgnoreProperties("animalGroups")
	    Set<Address> addresses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnimalGroupNumber() {
		return animalGroupNumber;
	}

	public void setAnimalGroupNumber(String animalGroupNumber) {
		this.animalGroupNumber = animalGroupNumber;
	}

	public String getAgType() {
		return agType;
	}

	public void setAgType(String agType) {
		this.agType = agType;
	}

	public List<TestModel> getTest() {
		return test;
	}

	public void setTest(List<TestModel> test) {
		this.test = test;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
	
}
