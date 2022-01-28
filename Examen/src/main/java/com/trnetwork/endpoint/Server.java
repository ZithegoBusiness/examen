package com.trnetwork.endpoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.entity.EMPLOYEES;
import com.trnetwork.entity.JOBS;
import com.trnetwork.entity.response;
import com.trnetwork.interfaces.EMPLOYEES_DAO;
import com.trnetwork.interfaces.EMPLOYEE_WORKED_HOURS_DAO;
import com.trnetwork.interfaces.GENDERS_DAO;
import com.trnetwork.interfaces.JOBS_DAO;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/examen")
public class Server {

	@Autowired
	GENDERS_DAO gender;
	
	@Autowired
	JOBS_DAO jobs;
	
	@Autowired
	EMPLOYEE_WORKED_HOURS_DAO ewh;
	
	@Autowired
	EMPLOYEES_DAO employees;
	
	@PostMapping
	public response<Integer> setEmployees(@RequestBody EMPLOYEES employee_required)
	{
		try {
			Date c = new Date();
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthdate=sdf.format(employee_required.gebirdate());
			String current_Date=sdf.format(date);
			
			String[] aCurrent_Date = current_Date.split("-") ;
			Integer cd_anio = Integer.parseInt(aCurrent_Date[0]);
			
			
			String[] aDate_Birthdate = birthdate.split("-") ;
			Integer b_anio = Integer.parseInt(aDate_Birthdate[0]);*/
			System.out.println(c.getYear()+1900);
			System.out.println(employee_required.gebirdate().getYear()+1900);
			
			
			if( ((c.getYear()-employee_required.gebirdate().getYear())+1900) >18 ) {
				Optional<JOBS> busqueda = jobs.findById(employee_required.getjob_id());
				
				if(busqueda.isPresent())
				{
					EMPLOYEES e= employees.save(employee_required);
					
					return new response<Integer>(e.getid(), false);
				}
			}
			
			
			
			
			return new response<Integer>(null, false);
			
		}catch (Exception e) {
			return new response<Integer>(null, false);
		}
	}
	
	@GetMapping
	public void getEmployees(@RequestParam(required = true) int job_id){
		List<EMPLOYEES> busqueda;
		busqueda= employees.findByJOB_ID(job_id);
		if(busqueda.size()>0)
		busqueda.forEach(e ->{
			System.out.println(e);
		});
		
		
	}
	
}
