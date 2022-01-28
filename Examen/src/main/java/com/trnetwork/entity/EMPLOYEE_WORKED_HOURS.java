package com.trnetwork.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class EMPLOYEE_WORKED_HOURS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	private Integer EMPLOYEE_ID;
	private Integer WORKED_HOURS;
	private Date WORKED_DATE;
	
	public EMPLOYEE_WORKED_HOURS() {
		
	}
	
	public EMPLOYEE_WORKED_HOURS(Integer employee_id, Integer worked_hours, Date worked_date) {
		EMPLOYEE_ID = employee_id;
		WORKED_HOURS = worked_hours;
		WORKED_DATE = worked_date;
	}
	
	public Integer getID() {
		return ID;
	}
	public void setid(Integer id) {
		this.ID = id;
	}
	public Integer getemployee_id() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(Integer employee_id) {
		EMPLOYEE_ID = employee_id;
	}
	public Integer getworked_hours() {
		return WORKED_HOURS;
	}
	public void setworked_hours(Integer worked_hours) {
		WORKED_HOURS = worked_hours;
	}
	public Date getworked_date() {
		return WORKED_DATE;
	}
	public void setworked_date(Date worked_date) {
		WORKED_DATE = worked_date;
	}
	
	

}
