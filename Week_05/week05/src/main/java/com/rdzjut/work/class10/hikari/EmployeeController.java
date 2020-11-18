package com.rdzjut.work.class10.hikari;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/add")
    public String add() {
        Employee employee = new Employee();
        employee.setEmployeeAge("18");
        employee.setEmployeeName("王五");
        System.out.println(employeeService.addOrUpdate(employee));
        return "新增用户组";
    }

    @RequestMapping("/find")
    public String find(Employee employee) {
        long id = employee.getId();
        employee = employeeService.find(id);
        return employee == null ? "查无此人" : employee.getEmployeeName();
    }

    @RequestMapping("/update")
    public String update(Employee employee) {
        employee.setEmployeeName("李四");
        employeeService.addOrUpdate(employee);
        return "更新用户组";
    }

    @RequestMapping("/delete")
    public String delete(long id) {
        employeeService.delete(id);
        return "删除用户组";
    }
}
