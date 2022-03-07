package com.example.Restwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
