package com.rdzjut.work.class10.hikari;

public interface EmployeeService {
    public Employee addOrUpdate(Employee employee);
    public void delete(long id);
    public Employee find(long id);
}
