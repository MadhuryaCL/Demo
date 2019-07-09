
package com.crud_operations.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud_operations.domain.StudentContactDomain;
import com.crud_operations.response.Response;
import com.crud_operations.status.StatusCode;
import com.crud_operations.utils.CommonUtils;

@Repository
@Transactional
public class StudentContactDaoImpl implements StudentContactDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	StudentContactDaoRepository studentcontactdaorepository;
	
	@Override
	public Response addStudentContact(StudentContactDomain studentcontact) throws Exception {
		Response response = CommonUtils.getResponseObject("Add student contact");
		try {
			entityManager.persist(studentcontact);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@Override
	public Response updateStudentContact(StudentContactDomain studentcontact) throws Exception {
		Response response = CommonUtils.getResponseObject("Update student contact");

		// TODO Auto-generated method stub
		try {
		
			StudentContactDomain studentcontacts = getStudentContact(studentcontact.getId());
			studentcontacts.setPhoneNo(studentcontact.getPhoneNo());
			
	
			studentcontactdaorepository.saveAndFlush(studentcontacts);
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
	public Response deleteStudentContact(int id) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete student contact");

		try {
			StudentContactDomain studentcontact=getStudentContact(id);
		entityManager.remove(studentcontact);
		response.setStatus(StatusCode.SUCCESS.name());
		return response;
		}catch(Exception s) {
			System.out.println(s);
		}
		return null;
	}

	@Override
	public StudentContactDomain getStudentContact(int id) throws Exception {
		String hql="From StudentContactDomain where id=:ab";
		return (StudentContactDomain) entityManager.createQuery(hql).setParameter("ab", id).getSingleResult();
	}

	@Override
	public List<StudentContactDomain> getStudentContacts() throws Exception {
		try {
			List<StudentContactDomain> listStudentContactDomain=studentcontactdaorepository.findAll();
			return listStudentContactDomain;
		}catch(Exception e1) {
			System.out.println(e1);
		}
		return null;
	}
	
	

}
