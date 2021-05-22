package com.workmotion.poc.employee.contract;

import com.workmotion.poc.employee.entity.EmployeeEntity;

import java.util.List;

/**
 * 5/22/2021
 * CREATED BY @Ayman Alsapagh
 **/
public interface EmployeeContract {

    EmployeeEntity insertNewEmplyee(EmployeeEntity employeeEntity);

    EmployeeEntity changeEmplyeeState(Integer employeeid);

    List<EmployeeEntity> getAllEmployees();
}
