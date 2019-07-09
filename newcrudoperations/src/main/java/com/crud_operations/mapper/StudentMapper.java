package com.crud_operations.mapper;

import org.springframework.stereotype.Component;

import com.crud_operartions.model.StudentModel;
import com.crud_operations.abstract_mapper.AbstractModelMapper;
import com.crud_operations.domain.StudentDomain;



@Component
public class StudentMapper extends AbstractModelMapper<StudentModel, StudentDomain> {
	
	public Class<StudentModel> entityType() {
		return StudentModel.class;
	}
	
	public Class<StudentDomain> modelType() {
		return StudentDomain.class;
	
}

}
