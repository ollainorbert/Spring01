package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Human;

@Repository
public class HumanJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Human findById(long id) {
		return jdbcTemplate.queryForObject("select * from human where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Human>(Human.class));
	}
	
	public Human findByName(String name) {
		return jdbcTemplate.queryForObject("select * from human where name=?", new Object[] { name },
				new BeanPropertyRowMapper<Human>(Human.class));
	}

	public List<Human> findAll() {
		return jdbcTemplate.queryForList("select * from human", Human.class,
				new BeanPropertyRowMapper<Human>(Human.class));
	}

	public List<Human> findAll2() {
		return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<Human>(Human.class));
	}

}
