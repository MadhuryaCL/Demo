package com.crud_operations.dao;

import java.util.List;

import com.crud_operations.domain.StudentContactDomain;
import com.crud_operations.response.Response;

public interface StudentContactDao {

public Response addStudentContact(StudentContactDomain studentcontact) throws Exception;
	
	public Response updateStudentContact(StudentContactDomain  studentcontact) throws Exception;

	public Response deleteStudentContact(int id) throws Exception;

	public StudentContactDomain  getStudentContact(int id) throws Exception;

	public List<StudentContactDomain> getStudentContacts() throws Exception;

}
