package com.mani.demoforJpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String studentName;
	private String studentMailId;
	private String studnetAddres;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMailId() {
		return studentMailId;
	}
	public void setStudentMailId(String studentMailId) {
		this.studentMailId = studentMailId;
	}
	public String getStudnetAddres() {
		return studnetAddres;
	}
	public void setStudnetAddres(String studnetAddres) {
		this.studnetAddres = studnetAddres;
	}
	
	public student(long id, String studentName, String studentMailId, String studnetAddres) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentMailId = studentMailId;
		this.studnetAddres = studnetAddres;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", studentName=" + studentName + ", studentMailId=" + studentMailId
				+ ", studnetAddres=" + studnetAddres + "]";
	}	
	
	
	}
