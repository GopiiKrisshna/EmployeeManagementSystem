package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public void deleteEmployee(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123456");
            String query = "DELETE FROM employee_details WHERE employee_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            String query1 = "DELETE FROM employees WHERE employee_id=?";
            ps = con.prepareStatement(query1);
            ps.setInt(1, id);
            int recordDeleted = ps.executeUpdate();
            if(recordDeleted>0){
                System.out.println("The Record of the employee Id - "+id+" Deleted Successfully!");
            }else {
                System.out.println("NO such Record Found!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------\n");
    }
}
