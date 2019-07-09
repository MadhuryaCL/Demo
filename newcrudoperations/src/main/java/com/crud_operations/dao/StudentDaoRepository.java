
package com.crud_operations.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.crud_operations.domain.StudentDomain;

public interface StudentDaoRepository extends JpaRepository<StudentDomain,Integer > {
	


}
