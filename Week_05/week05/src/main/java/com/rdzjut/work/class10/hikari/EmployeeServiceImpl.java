package com.rdzjut.work.class10.hikari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee find(long id){
        return employeeDao.getOne(id);
    }

    public Employee addOrUpdate(Employee employee){
        return employeeDao.save(employee);
    }

    public void delete(long id){
        employeeDao.deleteById(id);
    }
}
