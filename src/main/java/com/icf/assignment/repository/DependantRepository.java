package com.icf.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icf.assignment.model.Dependant;

@Repository
public interface DependantRepository extends JpaRepository<Dependant, Long>{

}
