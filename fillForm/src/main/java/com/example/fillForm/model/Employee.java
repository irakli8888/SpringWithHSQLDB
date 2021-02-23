package com.example.fillForm.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "media_path")
    private String mediaPath;

    @Column(length = 500)
    private String description;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @Column(name = "is_active")
    private boolean isActive;

}
