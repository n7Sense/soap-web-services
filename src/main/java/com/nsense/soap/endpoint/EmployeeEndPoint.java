package com.nsense.soap.endpoint;

import com.nsense.artifact.employee.*;
import com.nsense.domain.BankAccount;
import com.nsense.domain.EmployeeDomain;
import com.nsense.services.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Endpoint
public class EmployeeEndPoint {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PayloadRoot(namespace = "http://artifact.nsense.com/employee", localPart = "getEmployeeListRequest")
    @ResponsePayload
    public GetEmployeeListResponse getEmployeeListRequest(@RequestPayload GetEmployeeListRequest request) {
        GetEmployeeListResponse response = new GetEmployeeListResponse();
        List<Employee> employeeAutoList = new ArrayList<>();
        List<EmployeeDomain> employeeList = employeeService.findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee ob = new Employee();
            BeanUtils.copyProperties(employeeList.get(i), ob);
           // if(request.getFunction()=="list")
            employeeAutoList.add(ob);
        }
        response.getEmployeeList().addAll(employeeAutoList);
        return response;
    }

    @PayloadRoot(namespace = "http://artifact.nsense.com/employee", localPart = "editEmployeeDetailsRequest")
    @ResponsePayload
    public EditEmployeeDetailsResponse editEmployeeDetailsRequest(@RequestPayload EditEmployeeDetailsRequest request) {
        EditEmployeeDetailsResponse response = new EditEmployeeDetailsResponse();
        EmployeeDomain employee = new EmployeeDomain();
        BeanUtils.copyProperties(request.getEmployee(), employee);
        employeeService.update(employee);
        Message message = new Message();
        message.setMessage("SUCCESS");
        response.setMessage(message);
        return response;
    }

    @PayloadRoot(namespace = "http://artifact.nsense.com/employee", localPart = "createEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse creteEmployeeRequest(@RequestPayload CreateEmployeeRequest request) {
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        EmployeeDomain employee = new EmployeeDomain();
        BeanUtils.copyProperties(request.getCreateEmployee(), employee);

        System.out.println("*9***************************\n"+employee.toString());
        employeeService.save(employee);
        Message message = new Message();
        //message.setMessage("SUCCESS");
        response.setMessage("SUCCESS");
        return response;
    }

    @PayloadRoot(namespace = "http://artifact.nsense.com/employee", localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployeeRequest(@RequestPayload DeleteEmployeeRequest request) {
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        employeeService.delete(request.getEmployeeId());
        Message message = new Message();
        message.setMessage("SUCCESS");
        response.setMessage(message);
        return response;
    }
}
