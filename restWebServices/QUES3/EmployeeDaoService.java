package com.example.Restwebservices;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeDaoService {
    private static List<EmployeeBean> employee=new ArrayList<>();
    static {
        employee.add(new EmployeeBean(101,"MEENU",25));
        employee.add(new EmployeeBean(102,"RADHA",24));
        employee.add(new EmployeeBean(103,"YASH",26));
        employee.add(new EmployeeBean(104,"SANJAY",25));
        employee.add(new EmployeeBean(105,"RANU",24));
        }

    public List<EmployeeBean> findallemp(){
        return employee;
    }
}
