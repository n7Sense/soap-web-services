package com.techprimers.springbootsoapexample.endpoint;

import com.nsense.employee.*;
import com.techprimers.springbootsoapexample.services.EmployeeServiceImpl;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class EmployeeEndPoint {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PayloadRoot(namespace = "http://nsense.com/employee", localPart = "getEmployeeListRequest")
    @ResponsePayload
    public GetEmployeeListResponse getEmployeeListRequest(@RequestPayload GetEmployeeListRequest request) {
        GetEmployeeListResponse response = new GetEmployeeListResponse();
        List<com.nsense.employee.Employee> employeeAutoList = new ArrayList<>();
        List<com.techprimers.springbootsoapexample.domain.Employee> employeeList = employeeService.findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            com.nsense.employee.Employee ob = new com.nsense.employee.Employee();
            BeanUtils.copyProperties(employeeList.get(i), ob);
           // if(request.getFunction()=="list")
            employeeAutoList.add(ob);
        }
        response.getEmployeeList().addAll(employeeAutoList);
        return response;
    }

    @PayloadRoot(namespace = "http://nsense.com/employee", localPart = "editEmployeeDetailsRequest")
    @ResponsePayload
    public EditEmployeeDetailsResponse editEmployeeDetailsRequest(@RequestPayload EditEmployeeDetailsRequest request) {
        EditEmployeeDetailsResponse response = new EditEmployeeDetailsResponse();
        com.techprimers.springbootsoapexample.domain.Employee employee = new com.techprimers.springbootsoapexample.domain.Employee();
        BeanUtils.copyProperties(request.getEmployee(), employee);
        employeeService.update(employee);
        Message message = new Message();
        message.setMessage("SUCCESS");
        response.setMessage(message);
        return response;
    }
}
