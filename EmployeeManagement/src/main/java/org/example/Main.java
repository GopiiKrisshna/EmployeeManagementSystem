package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            AddEmployee addEmployee = new AddEmployee();
            ViewEmployee viewEmployee = new ViewEmployee();
            EditEmployee editEmployee = new EditEmployee();
            DeleteEmployee deleteEmployee = new DeleteEmployee();
            System.out.println("\n------Employee Management System------");
            System.out.println("\n-----Choose your Operation-----");
            boolean exit = false;
            while(!exit){
                System.out.println("1.Add New Employee\n2.View Employee Details\n3.Edit Employee Details\n4.Delete Employee Details\n5.Exit");
                System.out.print("Enter your choice : ");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        addEmployee.addEmployee();
                        break;
                    case 2:
                        System.out.println("1.Get Employee By Employee ID\n2.Get Employees By Department");
                        System.out.print("Enter your choice : ");
                        int option = scanner.nextInt();
                        if(option==1){
                            System.out.print("Enter Employee ID : ");
                            int id = scanner.nextInt();
                            viewEmployee.viewEmployee(id);
                        }else if(option==2){
                            System.out.print("Enter Department Name : ");
                            String department = scanner.next();
                            viewEmployee.viewEmployeeByDepartment(department);
                        }
                        break;
                    case 3:
                        System.out.print("Enter Employee ID : ");
                        int id = scanner.nextInt();
                        editEmployee.EditEmployee(id);
                        break;
                    case 4:
                        System.out.print("Enter Employee ID : ");
                        int empId = scanner.nextInt();
                        deleteEmployee.deleteEmployee(empId);
                        break;
                    case 5:
                        System.out.print("Thank you! Visit again for any information!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input! Try again");
                }
            }
    }
}