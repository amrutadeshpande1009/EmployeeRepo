

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

    public class EmployeeRepository {

        public List<Department> getDepartments() {
            return Arrays.asList(
                    new Department(1, "HR"),
                    new Department(2, "Finance"),
                    new Department(3, "IT"),
                    new Department(4, "Marketing")
            );
        }

        public List<Employee> getEmployees() {
            Department hr = new Department(1, "HR");
            Department finance = new Department(2, "Finance");
            Department it = new Department(3, "IT");

            Employee manager1 = new Employee(100, "Manager A", 90000, LocalDate.of(2010, 1, 10), hr, null);
            Employee manager2 = new Employee(101, "Manager B", 95000, LocalDate.of(2012, 3, 15), finance, null);

            return Arrays.asList(
                    manager1,
                    manager2,
                    new Employee(102, "Alice", 60000, LocalDate.of(2015, 5, 20), hr, manager1),
                    new Employee(103, "Bob", 55000, LocalDate.of(2016, 7, 25), finance, manager2),
                    new Employee(104, "Charlie", 70000, LocalDate.of(2018, 9, 30), it, manager2),
                    new Employee(105, "David", 50000, LocalDate.of(2020, 11, 5), null, manager1),
                    new Employee(106, "Eve", 65000, LocalDate.of(2021, 1, 12), it, null)
            );
        }
    }


