package com.matheushdb.projectapirestdio.repository;

import com.matheushdb.projectapirestdio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
