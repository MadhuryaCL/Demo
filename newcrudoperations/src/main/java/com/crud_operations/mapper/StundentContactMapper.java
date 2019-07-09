package com.crud_operations.mapper;

import org.springframework.stereotype.Component;

import com.crud_operartions.model.StudentContactModel;
import com.crud_operations.abstract_mapper.AbstractModelMapper;
import com.crud_operations.domain.StudentContactDomain;

@Component
public class StundentContactMapper extends AbstractModelMapper<StudentContactModel, StudentContactDomain>{

	@Override
	public Class<StudentContactModel> entityType() {
		// TODO Auto-generated method stub
		return StudentContactModel.class;
	}

	@Override
	public Class<StudentContactDomain> modelType() {
		// TODO Auto-generated method stub
		return StudentContactDomain.class;
	}

}
