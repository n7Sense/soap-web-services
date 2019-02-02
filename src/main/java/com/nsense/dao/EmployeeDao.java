package com.nsense.dao;

import com.nsense.domain.EmployeeDomain;

import java.util.List;

public interface EmployeeDao {

    public void save(EmployeeDomain employee);
    public List<EmployeeDomain> findAll();
    public void update(EmployeeDomain employee);
    public void delete(int empId);
    public EmployeeDomain findById(int empId);
}
