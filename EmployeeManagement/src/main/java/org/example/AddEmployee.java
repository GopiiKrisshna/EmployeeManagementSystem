package org.example;

import java.sql.*;
import java.util.Scanner;

public class AddEmployee {
    public void addEmployee(){
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            System.out.print("Enter employee name : ");
            String name = scanner.nextLine();
            System.out.print("Enter employee address : ");
            String address = scanner.nextLine();
            String email;
            while (true) {
                System.out.print("Enter employee email : ");
                email = scanner.nextLine();
                if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
                    break;
                System.out.println("Invalid email. Try again!");
            }
            String phone;
            while (true) {
                System.out.print("Enter employee phone : ");
                phone = scanner.nextLine();
                if (phone.matches("^[0-9]{10}$"))
                    break;
                System.out.println("Invalid phone number. Try again!");
            }
            String dob;
            while (true) {
                System.out.print("Enter employee Date_Of_Birth (dd-mm-yyyy) : ");
                dob = scanner.nextLine();
                if (dob.matches("^\\d{2}-\\d{2}-\\d{4}$"))
                    break;
                System.out.println("Invalid format. Try again!");
            }
            String bloodGroup;
            while (true) {
                System.out.print("Enter employee Blood group : ");
                bloodGroup = scanner.nextLine();
                if (bloodGroup.matches("^(A|A1|B|B1|AB|O|HH)[+-]$"))
                    break;
                System.out.println("Invalid format. Try again!");
            }
            System.out.print("Enter employee department : ");
            String department = scanner.nextLine();
            System.out.print("Enter employee designation : ");
            String designation = scanner.nextLine();
            System.out.print("Enter employee salary : ");
            float salary = scanner.nextFloat();

            String EmployeeQuery = "INSERT INTO employees(employee_name,department,designation,salary) VALUES ( ?, ?, ?, ?) RETURNING employee_id";
            PreparedStatement ps = con.prepareStatement(EmployeeQuery);
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, designation);
            ps.setFloat(4, salary);
            ResultSet rs = ps.executeQuery();

            int employeeId = -1;
            if (rs.next()) {
                employeeId = rs.getInt("employee_id");
            }

            String DetailsQuery = "INSERT INTO employee_details(employee_id,email_id,phone_number,address,date_of_birth,blood_group) VALUES ( ?, ?, ?, ?, ?, ?) RETURNING employee_id";
            PreparedStatement detailsPs = con.prepareStatement(DetailsQuery);
            detailsPs.setInt(1, employeeId);
            detailsPs.setString(2, email);
            detailsPs.setString(3, phone);
            detailsPs.setString(4, address);
            detailsPs.setString(5, dob);
            detailsPs.setString(6, bloodGroup);
            detailsPs.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Successfully added the Employee!");
        System.out.println("--------------------------------\n");
    }
}
