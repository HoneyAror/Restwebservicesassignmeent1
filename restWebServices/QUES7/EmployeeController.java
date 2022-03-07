package com.example.Restwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDaoService service;
    @GetMapping(path = "/employee")
    //method to handle all get request
    public List<EmployeeBean> getallemployee(){
        return service.findallemp();
    }
    @GetMapping(path ="/employee/{id}")
    public EmployeeBean getemployee(@PathVariable int id){
        EmployeeBean employeeBean=service.findone(id);
        if(employeeBean==null)
            throw new EmployeeNotFoundException("id-"+id);
        return employeeBean;
    }
    //Create new user
    //input:details of user
    //output:created emp and its uri
    @PostMapping("/employee")
    public void CreateEmp(@RequestBody EmployeeBean employeeBean){
        EmployeeBean saveEmp=service.SaveEmp(employeeBean);

    }
    @DeleteMapping(path ="/employee/{id}")
    public void Deleteemployee(@PathVariable int id){
        EmployeeBean employeeBean=service.Deletebyid(id);
        if(employeeBean==null)
            throw new EmployeeNotFoundException("id-"+id);
    }

}
