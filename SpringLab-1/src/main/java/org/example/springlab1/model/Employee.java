package org.example.springlab1.model;

public class Employee {
    private Long employeeId;
    private String department;
    private String name;
    private String status;

    public Employee(){};

    public Employee(Long employeeId, String department, String name, String status){
        this.employeeId=employeeId;
        this.department=department;
        this.name=name;
        this.status=status;
    }

    public Long getEmployeeId(){
        return employeeId;
    }

    public  void setEmployeeId(Long employeeId){
        this.employeeId=employeeId;
    }

    public String getDepartment(){
        return  department;
    }
    public String getName(){
        return name;

    }

    public String  getStatus(){
        return status;
    }

    public void setDepartment(String status){
        this.status=status;
    }
    public void setName(String name){
        this.name=name;
    }

    public  void setStatus(String status){
        this.status=status;
    }



}
