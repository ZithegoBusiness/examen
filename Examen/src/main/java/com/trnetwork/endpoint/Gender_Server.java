package com.trnetwork.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.entity.GENDERS;
import com.trnetwork.interfaces.GENDERS_DAO;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/gender")
public class Gender_Server {
	@Autowired
	GENDERS_DAO gender;
	
	@GetMapping
	public String hola()
	{
		return "hola";
	}
	
	@PostMapping
	public ResponseEntity<Integer> insertGender(@RequestBody GENDERS gender_request) {
		try {
			GENDERS g = gender.save( gender_request);
			
			if(g.getId()>0)
			{
				return new ResponseEntity<Integer>(g.getId(),HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
}
