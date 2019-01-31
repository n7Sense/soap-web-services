package com.techprimers.springbootsoapexample.repository;

import com.techprimers.springbootsoapexample.dao.EmployeeDao;
import com.techprimers.springbootsoapexample.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author nSense
 */

@Repository
@Transactional
public class EmployeeRepository implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public List<Employee> findAll() {

        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Employee> list= session.createCriteria(Employee.class).list();
        return list;
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Override
    public void delete(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = findById(employeeId);
        session.delete(employee);
    }

    @Override
    public Employee findById(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee)session.get(Employee.class, employeeId);
        return employee;
    }
}
