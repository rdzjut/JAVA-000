package com.rdzjut.work.class10.hikari;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    /**
     * 主键，自增
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 员工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * 员工年龄
     */
    @Column(name = "employee_age")
    private String employeeAge;
}
