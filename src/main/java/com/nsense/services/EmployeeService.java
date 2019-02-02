package com.nsense.services;


import com.nsense.domain.EmployeeDomain;

import java.util.List;

public interface EmployeeService {

    public void save(EmployeeDomain employee);
    public List<EmployeeDomain> findAll();
    public void update(EmployeeDomain employee);
    public void delete(int empId);
    public EmployeeDomain findById(int empId);
}
