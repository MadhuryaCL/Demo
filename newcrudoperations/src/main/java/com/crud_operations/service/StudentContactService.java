package com.crud_operations.service;

import java.util.List;

import com.crud_operartions.model.StudentContactModel;
import com.crud_operations.response.Response;

public interface StudentContactService {
	
public Response addStudentContact(StudentContactModel studentcontactmodel) throws Exception;
	
	public List<StudentContactModel> getStudents() throws Exception;

	public Response updateStudent(int id) throws Exception;

	public Response deleteStudent(int id) throws Exception;

	public StudentContactModel getStudent(int id) throws Exception;


}
