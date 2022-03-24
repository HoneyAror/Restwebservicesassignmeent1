package com.example.Restwebservices.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {              //talking to database and getting result
    private static List<EmployeeBean> employee=new ArrayList<>();
    private static int  usercount=105;
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
    public EmployeeBean findone(int id){
        for(EmployeeBean e:employee){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }
    public EmployeeBean SaveEmp(EmployeeBean employeeBean){
        if(employeeBean.getId()==null){
            employeeBean.setId(++usercount);
        }
        employee.add(employeeBean);
        return employeeBean;
    }
    public EmployeeBean updateEmp( int id) {
        for(EmployeeBean v :employee){
            if(v.getId()==id)
            {
                v.setName("HONEY");
                v.setAge(25);
            }
            return v;
        }
        return (EmployeeBean) employee;
    }
    public EmployeeBean Deletebyid(int id){
        Iterator<EmployeeBean> iterator=employee.iterator();
        while (iterator.hasNext()){
            EmployeeBean employeeBean=iterator.next();
            for(EmployeeBean e:employee){
                if(e.getId()==id){
                    iterator.remove();
                    return e;
                }
            }
        }
        return null;
    }

}
