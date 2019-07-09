package com.crud_operations.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_operations.domain.StudentContactDomain;

public interface StudentContactDaoRepository extends JpaRepository<StudentContactDomain, Integer> {

}
