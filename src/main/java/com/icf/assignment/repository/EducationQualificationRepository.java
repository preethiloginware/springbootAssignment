package com.icf.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icf.assignment.model.EducationQualification;

@Repository
public interface EducationQualificationRepository extends JpaRepository<EducationQualification, Long>{

}
