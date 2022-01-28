package com.trnetwork.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class EMPLOYEES {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	private Integer GENDER_ID;
	private Integer JOB_ID;
	
	@Column (unique = true)
	private String NAME;
	@Column (unique = true)
	private String LAST_NAME;
	private Date BIRTHDATE;
	
	public EMPLOYEES() {
		
	}
	
	
	
	public EMPLOYEES(Integer gender_id, Integer job_id, String name, String last_name, Date birthdate) {
		GENDER_ID = gender_id;
		JOB_ID = job_id;
		NAME = name;
		LAST_NAME = last_name;
		BIRTHDATE = birthdate;
	}



	public Integer getid() {
		return ID;
	}
	public void setid(Integer id) {
		ID = id;
	}
	public Integer getgender_id() {
		return GENDER_ID;
	}
	public void setgender_id(Integer gender_id) {
		GENDER_ID = gender_id;
	}
	public Integer getjob_id() {
		return JOB_ID;
	}
	public void setjob_id(Integer job_id) {
		JOB_ID = job_id;
	}
	public String getname() {
		return NAME;
	}
	public void setname(String name) {
		NAME = name;
	}
	public String getlast_name() {
		return LAST_NAME;
	}
	public void setlast_name(String last_name) {
		LAST_NAME = last_name;
	}
	public Date gebirdate() {
		return BIRTHDATE;
	}
	public void setbirthdate(Date birthdate) {
		BIRTHDATE = birthdate;
	}



	@Override
	public String toString() {
		return "EMPLOYEES [ID=" + ID + ", GENDER_ID=" + GENDER_ID + ", JOB_ID=" + JOB_ID + ", NAME=" + NAME
				+ ", LAST_NAME=" + LAST_NAME + ", BIRTHDATE=" + BIRTHDATE + "]";
	}
	
	

}
