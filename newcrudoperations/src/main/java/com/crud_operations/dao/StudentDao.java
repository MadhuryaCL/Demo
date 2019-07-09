package com.crud_operations.dao;

import java.util.List;

import com.crud_operations.domain.StudentDomain;
import com.crud_operations.response.Response;



public interface StudentDao {
	
	public Response addStudent(StudentDomain student) throws Exception;
	
	public Response updateStudent(StudentDomain  student) throws Exception;

	public Response deleteStudent(int id) throws Exception;

	public StudentDomain  getStudent(int id) throws Exception;

	public List<StudentDomain> getStudents() throws Exception;

}
