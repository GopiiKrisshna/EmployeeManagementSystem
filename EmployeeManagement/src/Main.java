
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Aathini","Product",20000));
        employees.add(new Employee(2,"Arjun","Testing",22000));
        employees.add(new Employee(3,"Vikram","Implementaion",25000));
        employees.add(new Employee(4,"Nirupama","Product Support",21000));
        employees.add(new Employee(5,"Vennila","Sales",23000));

        // Search Employee By Department
        System.out.print("Search by depatment : ");
        String searchEmployee = input.nextLine();
        List<Employee> empByDept = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(searchEmployee))
                .toList();
        System.out.println("Employees in "+searchEmployee+" team");
        empByDept.forEach(System.out::println);

        //Sort employee by Salary
        System.out.println("\nEmployee - sorted with salary");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .forEach(System.out::println);

        //Get Highest paid Employee
        System.out.println("\nHighest Paid Employee ");
        employees.stream().max(Comparator.comparingInt(Employee::getSalary)).ifPresent(System.out::println);

        //Group employees by department
        Map<String, List<Employee>> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupByDept.forEach((dept, employeeList) -> {
            System.out.println(dept + " Team");
            employeeList.forEach(System.out::println);
        });
    }
}