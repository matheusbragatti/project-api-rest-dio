package com.matheushdb.projectapirestdio.repository;

import com.matheushdb.projectapirestdio.entity.Bill;
import com.matheushdb.projectapirestdio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
