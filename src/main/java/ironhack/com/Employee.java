package ironhack.com;

public class Employee {
    private int employee_id;
    private String department;
    private String name;
    private Status status;
    public Employee( int employee_id, String department,String name,Status status){
        this.employee_id=employee_id;
        this.department=department;
        this.name=name;
        this.status=status;
    }

    public void setEmployee_id(int employee_id) {this.employee_id = employee_id;}
    public void setDepartment(String department) {this.department = department;}
    public void setName(String name) {this.name = name;}
    public void setStatus(Status status) {this.status = status;}

    public int getEmployee_id() {return employee_id;}
    public String getDepartment() {return department;}
    public String getName() {return name;}
    public Status getStatus() {return status;}

}
