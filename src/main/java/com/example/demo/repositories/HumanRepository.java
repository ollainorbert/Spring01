package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Human;

public interface HumanRepository extends JpaRepository<Human, Long> {
	
	@Query
	public Human findByName(@Param("name") String name);
}
