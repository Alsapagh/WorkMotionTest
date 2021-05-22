package com.workmotion.poc.employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.workmotion.poc.employee.enums.States;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 5/22/2021
 * CREATED BY @Ayman Alsapagh
 **/
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    private Integer id;
    private String name;
    private States state;
    private Date birthDate;


    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer id, String name, States state, Date birthDate) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.birthDate = birthDate;
    }

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "STATE")
    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    @Column(name = "BIRTH_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
