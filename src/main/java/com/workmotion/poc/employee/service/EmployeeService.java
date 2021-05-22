package com.workmotion.poc.employee.service;

import com.workmotion.poc.employee.contract.EmployeeContract;
import com.workmotion.poc.employee.entity.EmployeeEntity;
import com.workmotion.poc.employee.enums.States;
import com.workmotion.poc.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.workmotion.poc.employee.enums.States.ACTIVE;
import static com.workmotion.poc.employee.enums.States.APPROVED;
import static com.workmotion.poc.employee.enums.States.INCHECK;

/**
 * 5/22/2021
 * CREATED BY @Ayman Alsapagh
 **/
@Service
public class EmployeeService implements EmployeeContract {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeEntity insertNewEmplyee(EmployeeEntity employeeEntity) {
        employeeEntity.setState(States.ADDED);
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public EmployeeEntity changeEmplyeeState(Integer employeeid) {
        Optional<EmployeeEntity> emp = employeeRepo.findById(employeeid);
        if (emp.isPresent()) {
            switch (emp.get().getState()) {
                case ADDED:
                    emp.get().setState(INCHECK);
                    break;
                case INCHECK:
                    emp.get().setState(APPROVED);
                    break;
                case APPROVED:
                    emp.get().setState(ACTIVE);
                    break;
                case ACTIVE:
                    break;

            }
            return employeeRepo.save(emp.get());
        }

        return null;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }


}
