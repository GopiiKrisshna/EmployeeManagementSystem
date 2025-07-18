package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditEmployee {
    public void EditEmployee(int id){
        Scanner scanner = new Scanner(System.in);
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123456");
            ViewEmployee view = new ViewEmployee();
            view.viewEmployee(id);
            System.out.println("Select the information that you want to change");
            System.out.println("\n1.Employee Name\n2.Employee Department\n3.Employee Designation\n4.Employee Salary" +
                    "\n5.Employee address\n6.Employee email\n7.Employee Phone Number\n8.Employee Dob\n9.Employee Blood Group"
            );
            boolean edit = true;
            while(edit){
                System.out.print("Enter number of the field to edit : ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                String Query = "";
                PreparedStatement ps = null;
                switch (choice) {
                    case 1:
                        System.out.print("Enter employee name : ");
                        String name = scanner.nextLine();
                        Query = "UPDATE employees SET employee_name = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, name);
                        ps.setInt(2,id);
                        break;
                    case 2:
                        System.out.print("Enter employee department : ");
                        String department = scanner.nextLine();
                        Query =  "UPDATE employees SET department = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, department);
                        ps.setInt(2,id);
                        break;
                    case 3:
                        System.out.print("Enter employee designation : ");
                        String designation = scanner.nextLine();
                        Query = "UPDATE employees SET designation = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, designation);
                        ps.setInt(2,id);
                        break;
                    case 4:
                        System.out.print("Enter employee salary : ");
                        float salary = scanner.nextFloat();
                        scanner.nextLine();
                        Query = "UPDATE employees SET salary = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setFloat(1, salary);
                        ps.setInt(2,id);
                        break;
                    case 5:
                        System.out.print("Enter employee address : ");
                        String address = scanner.nextLine();
                        Query = "UPDATE employee_details SET address = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, address);
                        ps.setInt(2,id);
                        break;
                    case 6:
                        System.out.print("Enter employee email : ");
                        String email = scanner.nextLine();
                        Query = "UPDATE employee_details SET email_id = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, email);
                        ps.setInt(2,id);
                        break;
                    case 7:
                        System.out.print("Enter employee phone number : ");
                        String phoneNumber = scanner.nextLine();
                        Query = "UPDATE employee_details SET phone_number = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, phoneNumber);
                        ps.setInt(2,id);
                        break;
                    case 8:
                        System.out.print("Enter employee date_of_birth : ");
                        String dateOfBirth = scanner.nextLine();
                        Query = "UPDATE employee_details SET date_of_birth = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, dateOfBirth);
                        ps.setInt(2,id);
                        break;
                    case 9:
                        System.out.print("Enter employee blood_group : ");
                        String bloodGroup = scanner.nextLine();
                        Query = "UPDATE employee_details SET blood_group = ? WHERE employee_id=?";
                        ps = con.prepareStatement(Query);
                        ps.setString(1, bloodGroup);
                        ps.setInt(2,id);
                        break;
                    default:
                        System.out.println("Invalid input! Try again");
                        continue;
                }
                ps.executeUpdate();
                System.out.println("Employee Detail Updated Successfully");
                System.out.print("Do you want change any other field? (Yes/No) : ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("No")) {
                    edit = false;
                }
                System.out.println("---------Here is the updated employee details-------");
                view.viewEmployee(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
