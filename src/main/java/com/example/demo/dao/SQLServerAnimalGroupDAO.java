package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AnimalGroup;

@Repository
public interface SQLServerAnimalGroupDAO extends JpaRepository<AnimalGroup, Integer> {
	
	public AnimalGroup findByAnimalGroupNumber(String animalGroupNumber);

}
