public class Employee {
    private int employeeId;
    private  String employeeName;
    private String department;
    private int salary;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(int employeeId, String employeeName, String department, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }
    public String toString() {
        return "Employee Id : " + employeeId + "\nEmployee Name : " + employeeName
                + "\nDepartment : " + department + "\nSalary : " + salary + "\n";
    }
}
