package com.nsense.services;

import com.nsense.dao.EmployeeDao;
import com.nsense.domain.EmployeeDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author nSense
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(EmployeeDomain emp) {
        employeeDao.save(emp);
    }

    @Override
    public List<EmployeeDomain> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void update(EmployeeDomain employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(int employeeId) {
        employeeDao.delete(employeeId);
    }

    @Override
    public EmployeeDomain findById(int employeeId) {
        return employeeDao.findById(employeeId);
    }
}
