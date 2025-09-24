//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

            public static void main(String[] args) {
                EmployeeRepository repository = new EmployeeRepository();
                EmployeeService service = new EmployeeService(repository);

                // Example calls
                System.out.println("Total Salary: " + service.getTotalSalary());

                System.out.println("\nDepartment Employee Count:");
                service.getDepartmentEmployeeCount().forEach((dept, count) ->
                        System.out.println(dept + ": " + count));

                System.out.println("\nSenior Most Employee:");
                service.getSeniorMostEmployee().ifPresent(e ->
                        System.out.println(e.getName() + " hired on " + e.getHireDate()));

                System.out.println("\nEmployees Without Department:");
                service.getEmployeesWithoutDepartment().forEach(e ->
                        System.out.println(e.getName()));

                System.out.println("\nEmployees Without Manager:");
                service.getEmployeesWithoutManager().forEach(e ->
                        System.out.println(e.getName()));
            }
        }

