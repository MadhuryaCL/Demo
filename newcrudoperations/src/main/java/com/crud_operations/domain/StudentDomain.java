package com.crud_operations.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentdatabase")
public class StudentDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stuid")
	private int stuid;

	
	@OneToOne(mappedBy="studentdomain",fetch=FetchType.EAGER)
	private StudentContactDomain studentcontactdomain;
	
	
	public StudentContactDomain getStudentcontactdomain() {
		return studentcontactdomain;
	}

	public void setStudentcontactdomain(StudentContactDomain studentcontactdomain) {
		this.studentcontactdomain = studentcontactdomain;
	}

	
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	

}
