package com.workmotion.poc.employee.controller;

import com.workmotion.poc.employee.contract.EmployeeContract;
import com.workmotion.poc.employee.entity.EmployeeEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 5/22/2021
 * CREATED BY @Ayman Alsapagh
 **/
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeContract employeeContract;


    /**
     * Insert New EMployee
     **/
    @ApiOperation(value = "Insert New Employee and return the Entity ", response = EmployeeEntity.class)
    @RequestMapping(method = RequestMethod.POST, value = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> insertNewEmplyee(
            @RequestBody() EmployeeEntity employee) {
        return new ResponseEntity(employeeContract.insertNewEmplyee(employee), HttpStatus.OK);

    }

    /**
     * getUpdate the Employee State based on his Current State
     **/
    @ApiOperation(value = "Update an Existing Employee by Passing its ID and return the Entity ", response = EmployeeEntity.class)
    @RequestMapping(method = RequestMethod.PUT, value = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> changeEmplyeeState(
            @RequestParam(name = "EmployeeId") Integer employeeId) {

        return new ResponseEntity(employeeContract.changeEmplyeeState(employeeId), HttpStatus.OK);

    }

    /**
     * get All Employees
     **/
    @ApiOperation(value = "Get All Current Employees ", response = EmployeeEntity.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, value = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeEntity>> getAllEmplyees() {


        return new ResponseEntity(employeeContract.getAllEmployees(), HttpStatus.OK);

    }

}
