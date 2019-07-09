package com.crud_operations.service;



import java.util.List;

import com.crud_operartions.model.StudentModel;
import com.crud_operations.response.Response;



public interface StudentService {
	

	public Response addStudent(StudentModel studentmodel) throws Exception;
	
	public List<StudentModel> getStudents() throws Exception;

	public Response updateStudent(int id) throws Exception;

	public Response deleteStudent(int id) throws Exception;

	public StudentModel getStudent(int id) throws Exception;

	

}
