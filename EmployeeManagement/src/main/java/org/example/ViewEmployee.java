package org.example;

import java.sql.*;

public class ViewEmployee {

    public static void printDetails(ResultSet rs) throws SQLException {
        System.out.println("\n------Employee details------");
        int employeeId = rs.getInt("employee_id");
        String employeeName = rs.getString("employee_name");
        String employeeDepartment = rs.getString("department");
        String employeeDesignation = rs.getString("designation");
        float salary = rs.getFloat("salary");
        String employeeAddress = rs.getString("address");
        String employeeEmail = rs.getString("email_id");
        String employeePhoneNumber = rs.getString("phone_number");
        String employeeDob = rs.getString("date_of_birth");
        String employeeBloodGroup = rs.getString("blood_group");
        System.out.println("Employee Id : " + employeeId + "\nEmployee Name : " + employeeName
                +"\nEmployee Dob : " + employeeDob + "\nEmployee Blood Group : " + employeeBloodGroup
                + "\nEmployee Email : " + employeeEmail + "\nEmployee Phone Number : " + employeePhoneNumber
                + "\nEmployee Address : " + employeeAddress + "\nEmployee Department : " + employeeDepartment
                + "\nEmployee Designation : " + employeeDesignation + "\nSalary : " + salary
        );
    }

    public void viewEmployee(int id){
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123456");
            String viewQuery = "SELECT * FROM employees e JOIN employee_details ed ON e.employee_id=ed.employee_id where e.employee_id=?";
            PreparedStatement ps = con.prepareStatement(viewQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ViewEmployee.printDetails(rs);
            }else {
                System.out.println("No Records of the employee found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------\n");
    }

    public void viewEmployeeByDepartment(String department){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456");
            String viewQuery = "SELECT * FROM employees e JOIN employee_details ed ON e.employee_id=ed.employee_id where department=?";
            PreparedStatement ps = con.prepareStatement(viewQuery);
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ViewEmployee.printDetails(rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        System.out.println("--------------------------------\n");
    }
}
