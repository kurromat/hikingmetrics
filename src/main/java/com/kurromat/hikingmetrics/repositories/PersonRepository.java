package com.kurromat.hikingmetrics.repositories;

import com.kurromat.hikingmetrics.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {

	Optional<Person> findByName(@Param("name") String name);
}
