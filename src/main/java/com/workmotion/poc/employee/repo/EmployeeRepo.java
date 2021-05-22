package com.workmotion.poc.employee.repo;

import com.workmotion.poc.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 5/22/2021
 * CREATED BY @Ayman Alsapagh
 **/
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {

}
