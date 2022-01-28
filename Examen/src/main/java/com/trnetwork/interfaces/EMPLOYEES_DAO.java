package com.trnetwork.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trnetwork.entity.EMPLOYEES;

public interface EMPLOYEES_DAO extends JpaRepository<EMPLOYEES, Integer> {
	@Query(value = "SELECT * FROM EMPLOYEES E WHERE E.JOB_ID = ? " , nativeQuery = true)
	List<EMPLOYEES> findByJOB_ID(int job_id);	
}
