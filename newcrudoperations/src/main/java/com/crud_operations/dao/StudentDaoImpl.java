package com.crud_operations.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud_operations.domain.StudentDomain;
import com.crud_operations.response.Response;
import com.crud_operations.status.StatusCode;
import com.crud_operations.utils.CommonUtils;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	StudentDaoRepository studentDaoRepository;
	
	@Override
	public Response addStudent(StudentDomain student) throws Exception {
		// TODO Auto-generated method stub
		Response response = CommonUtils.getResponseObject("Add student data");
		try {
			entityManager.persist(student);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
		
	}
	
	
	@Override
	
	public List<StudentDomain> getStudents() throws Exception {
		// TODO Auto-generated method stub
		//String hql="select * from bankdatabase";
		try {
			List<StudentDomain> listStudentDomain=studentDaoRepository.findAll();
			return listStudentDomain;
		/*String hql="FROM bankdatabase";
		return (List<BankDomain>)entityManager.createQuery(hql).getResultList();*/
		}catch(Exception e1) {
			System.out.println(e1);
		}
		return null;
	}


	@Override
	public Response updateStudent(StudentDomain student) throws Exception {
		Response response = CommonUtils.getResponseObject("Update student data");

		// TODO Auto-generated method stub
		try {
		
			StudentDomain students = getStudent(student.getStuid());
			//users.setId(user.getId());
			students.setName(student.getName());
			
	
			studentDaoRepository.saveAndFlush(students);
;			response.setStatus(StatusCode.SUCCESS.name());
			return  response;
		} catch (Exception e) {
			//logger.error("Exception in updateUser", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return null;
		
	}

	@Override
	public Response deleteStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		Response response = CommonUtils.getResponseObject("Delete student data");

		try {
			StudentDomain student=getStudent(id);
		entityManager.remove(student);
		response.setStatus(StatusCode.SUCCESS.name());
		return response;
		}catch(Exception s) {
			System.out.println(s);
		}
		return null;
	}

	@Override
	public StudentDomain getStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * BankDomain bankDomain=bankDaoRepository.findById(id); return bankDomain;
		 */
		
		String hql="From StudentDomain where id=:ab";
		return (StudentDomain) entityManager.createQuery(hql).setParameter("ab", id).getSingleResult();
	}
	


}
