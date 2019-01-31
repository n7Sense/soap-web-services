package com.techprimers.springbootsoapexample.dao;

import com.techprimers.springbootsoapexample.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    public void save(Employee employee);
    public List<Employee> findAll();
    public void update(Employee employee);
    public void delete(int empId);
    public Employee findById(int empId);
}
