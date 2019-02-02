package com.nsense.repository;

import com.nsense.dao.EmployeeDao;
import com.nsense.domain.EmployeeDomain;
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
    public void save(EmployeeDomain employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public List<EmployeeDomain> findAll() {

        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<EmployeeDomain> list= session.createCriteria(EmployeeDomain.class).list();
        return list;
    }

    @Override
    public void update(EmployeeDomain employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Override
    public void delete(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeDomain employee = findById(employeeId);
        session.delete(employee);
    }

    @Override
    public EmployeeDomain findById(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeDomain employee = (EmployeeDomain)session.get(EmployeeDomain.class, employeeId);
        return employee;
    }
}
