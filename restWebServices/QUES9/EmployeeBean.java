package com.example.Restwebservices;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class EmployeeBean {
    private Integer id;
    @Size(min=2)
    private String name;
    @NotNull @Min(20)
    private Integer age;
    protected EmployeeBean(){
    }

    public EmployeeBean(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
