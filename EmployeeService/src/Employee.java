
import java.time.LocalDate;

    public class Employee {
        private int id;
        private String name;
        private double salary;
        private LocalDate hireDate;
        private Department department;
        private Employee manager;

        public Employee(int id, String name, double salary, LocalDate hireDate, Department department, Employee manager) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.hireDate = hireDate;
            this.department = department;
            this.manager = manager;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public double getSalary() { return salary; }
        public LocalDate getHireDate() { return hireDate; }
        public Department getDepartment() { return department; }
        public Employee getManager() { return manager; }
    }

