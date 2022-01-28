package com.trnetwork.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.entity.JOBS;
import com.trnetwork.interfaces.JOBS_DAO;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/jobs")
public class Jobs_Server {
	
	@Autowired
	JOBS_DAO jobs;
	
	@PostMapping
	public ResponseEntity<Integer> insertGender(@RequestBody JOBS gender_request) {
		try {
			JOBS j = jobs.save( gender_request);
			
			if(j.getId()>0)
			{
				return new ResponseEntity<Integer>(j.getId(),HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}

}
