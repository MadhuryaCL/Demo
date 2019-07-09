package com.crud_operations.service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.crud_operartions.model.StudentModel;
import com.crud_operations.dao.StudentDao;
import com.crud_operations.dao.StudentDaoRepository;
import com.crud_operations.domain.StudentDomain;
import com.crud_operations.mapper.StudentMapper;
import com.crud_operations.response.Response;



@Service
public class StudentServiceImpl implements StudentService {
	 
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	StudentDaoRepository studentRepository;
	
	
	@Override
	public Response addStudent(StudentModel studentModel) throws Exception {
		// TODO Auto-generated method stub
		try {
		StudentDomain studentDomain=new StudentDomain();
		BeanUtils.copyProperties(studentModel,studentDomain );
		return 	studentDao.addStudent(studentDomain);

		}
		catch(Exception e) {
			System.out.println("Exception in add student");
			logger.error("Exception in add student");
		
		}
		return null;
	}
	
	@Override
	public List<StudentModel> getStudents() throws Exception {
		// TODO Auto-generated method stub
		try {
		List<StudentDomain> students = studentDao.getStudents();
		List<StudentModel> model=studentMapper.entityList(students);
		return model;
		}
		catch(Exception d) {
			System.out.println(d);
		}
		return null;
	}
	
	


	@Override
	public Response updateStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			
			/////////////////////Dao class Entity Manager///////////////////////////////
			StudentDomain studentDomain1=studentDao.getStudent(id);
			
			////////////////////-----------Repository------------------------////////////
			//BankDomain bankDomain1=bankRepository.findyId(id);
			StudentDomain studentDomain=new StudentDomain();
			studentDomain.setName(studentDomain1.getName());
			
			
		//BeanUtils.copyProperties(studentmodel, studentdomain);
		Response response = studentDao.updateStudent(studentDomain);
		return response;
	}
	catch(Exception e) {
		//logger.info("Exception in update Student"+e.getMessage());
		System.out.println(e);
	}
	return null;
		
	}


	@Override
	public StudentModel getStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
		StudentDomain student=studentDao.getStudent(id);
		StudentModel studentModel = new StudentModel();
		
		BeanUtils.copyProperties(student, studentModel);
		return studentModel;
		}catch(Exception e) {
		System.out.println(e);
		//logger.info("Exception getStudent:", e.getMessage());
		System.out.println(e);
		}
		return null;
	
	}

	@Override
	public Response deleteStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
		return studentDao.deleteStudent(id);
		}catch(Exception d)
		{
		System.out.println(d);
		}
		return null;
	}
	

}
