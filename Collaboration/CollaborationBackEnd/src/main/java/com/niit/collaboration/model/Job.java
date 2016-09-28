package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "JOB")
@Component
public class Job {

	private String jobId;
	private String description;
	private String qualification;
	private String experience;
	private int vacancies;

	@Id
	@Column(name="JOB_ID")
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
