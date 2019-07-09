package com.crud_operations.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_operartions.model.StudentContactModel;
import com.crud_operations.dao.StudentContactDao;
import com.crud_operations.dao.StudentContactDaoRepository;
import com.crud_operations.domain.StudentContactDomain;
import com.crud_operations.mapper.StundentContactMapper;
import com.crud_operations.response.Response;

@Service
public class StudentContactServiceImpl implements StudentContactService {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentContactServiceImpl.class);

	@Autowired
	StudentContactDao studentcontactdao;
	
	@Autowired
	StudentContactDaoRepository studentcontactdaorepository;
	
	@Autowired
	StundentContactMapper studentcontactmapper;
	
	@Override
	public Response addStudentContact(StudentContactModel studentcontactmodel) throws Exception {
		try {
			StudentContactDomain studentcontactdomain=new StudentContactDomain();
			BeanUtils.copyProperties(studentcontactmodel,studentcontactdomain );
			return 	studentcontactdao.addStudentContact(studentcontactdomain);

			}
			catch(Exception e) {
				System.out.println("Exception in add student contact");
				logger.error("Exception in add student contact");
			
			}
		return null;
	}

	@Override
	public List<StudentContactModel> getStudents() throws Exception {
		try {
			List<StudentContactDomain> studentcontacts = studentcontactdao.getStudentContacts();
			List<StudentContactModel> model=studentcontactmapper.entityList(studentcontacts);
			return model;
			}
			catch(Exception d) {
				System.out.println(d);
			}
		return null;
	}

	@Override
	public Response updateStudent(int id) throws Exception {
try {
	
			StudentContactDomain studentcontactdomain1=studentcontactdao.getStudentContact(id);
			StudentContactDomain studentcontactdomain=new StudentContactDomain();
			studentcontactdomain.setPhoneNo(studentcontactdomain1.getPhoneNo());
		Response response = studentcontactdao.updateStudentContact(studentcontactdomain);
		return response;
	}
	catch(Exception e) {
		System.out.println(e);
	}
		return null;
	}

	@Override
	public Response deleteStudent(int id) throws Exception {
		try {
			return studentcontactdao.deleteStudentContact(id);
			}catch(Exception d)
			{
			System.out.println(d);
			}
		return null;
	}

	@Override
	public StudentContactModel getStudent(int id) throws Exception {
		try {
			StudentContactDomain studentcontact=studentcontactdao.getStudentContact(id);
			StudentContactModel studentcontactmodel = new StudentContactModel();
			
			BeanUtils.copyProperties(studentcontact, studentcontactmodel);
			return studentcontactmodel;
			}catch(Exception e) {
			System.out.println(e);
			System.out.println(e);
			}
		return null;
	}

}
