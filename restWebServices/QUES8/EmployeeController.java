package com.example.Restwebservices.employee;

import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDaoService service;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/employee")
    //method to handle all get request
    public List<EmployeeBean> getallemployee(){
        return service.findallemp();
    }


    @GetMapping("employee/{id}")
    public EntityModel<EmployeeBean> specificUser(@PathVariable int id){
        EmployeeBean one = service.findone(id);
        if(one == null){
            throw new EmployeeNotFoundException("id :"+id);
        }
        EntityModel<EmployeeBean> resource = EntityModel.of(one);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getallemployee());
        resource.add(linkTo.withRel("all-users"));
        return resource;

    }


    //Create new user
    //input:details of user
    //output:created emp and its uri
    @PostMapping("/employee")
    public void CreateEmp(@Valid @RequestBody EmployeeBean employeeBean){
        EmployeeBean saveEmp=service.SaveEmp(employeeBean);
    }


    @DeleteMapping(path ="/employee/{id}")
    public void Deleteemployee(@PathVariable int id){
        EmployeeBean employeeBean=service.Deletebyid(id);
        if(employeeBean==null)
            throw new EmployeeNotFoundException("id-"+id);
    }
    @GetMapping(path = "/welcomeinternationalized")
    public String welcomeinternationalized(@RequestHeader(name="Accept-Language,required=false") Locale locale){

        return messageSource.getMessage("good.morning.message",null,locale);
    }

    @PutMapping("employees/{id}")
    public EmployeeBean updateEmployees(@RequestBody EmployeeBean employee,@PathVariable int id)
    {
        this.service.updateEmp(id);
        return employee;
    }


}
