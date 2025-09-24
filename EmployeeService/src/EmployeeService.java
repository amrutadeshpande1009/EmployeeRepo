
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

    public class EmployeeService {
        private EmployeeRepository repository;

        public EmployeeService(EmployeeRepository repository) {
            this.repository = repository;
        }

        // 14.6: Sum of salary of all employees
        public double getTotalSalary() {
            return repository.getEmployees()
                    .stream()
                    .mapToDouble(Employee::getSalary)
                    .sum();
        }

        // 14.7: Department names and count of employees in each department
        public Map<String, Long> getDepartmentEmployeeCount() {
            return repository.getEmployees()
                    .stream()
                    .filter(e -> e.getDepartment() != null)
                    .collect(Collectors.groupingBy(e -> e.getDepartment().getName(), Collectors.counting()));
        }

        // 14.8: Senior most employee
        public Optional<Employee> getSeniorMostEmployee() {
            return repository.getEmployees()
                    .stream()
                    .min(Comparator.comparing(Employee::getHireDate));
        }

        // 14.9: Employee name and duration of service
        public Map<String, String> getEmployeeServiceDuration() {
            return repository.getEmployees()
                    .stream()
                    .collect(Collectors.toMap(
                            Employee::getName,
                            e -> {
                                Period p = Period.between(e.getHireDate(), LocalDate.now());
                                return p.getMonths() + " months and " + p.getDays() + " days";
                            }
                    ));
        }

        // 14.10: Employees without department
        public List<Employee> getEmployeesWithoutDepartment() {
            return repository.getEmployees()
                    .stream()
                    .filter(e -> e.getDepartment() == null)
                    .collect(Collectors.toList());
        }

        // 14.11: Departments without employees
        public List<Department> getDepartmentsWithoutEmployees() {
            Set<Department> departmentsWithEmployees = repository.getEmployees()
                    .stream()
                    .map(Employee::getDepartment)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());

            return repository.getDepartments()
                    .stream()
                    .filter(d -> !departmentsWithEmployees.contains(d))
                    .collect(Collectors.toList());
        }

        // 14.12: Departments with highest count of employees
        public List<String> getDepartmentsWithHighestEmployeeCount() {
            Map<String, Long> deptCount = getDepartmentEmployeeCount();
            long max = deptCount.values().stream().max(Long::compare).orElse(0L);
            return deptCount.entrySet()
                    .stream()
                    .filter(e -> e.getValue() == max)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        // 14.13: Employee name, hire date and day of week
        public Map<String, String> getEmployeeHireDayInfo() {
            return repository.getEmployees()
                    .stream()
                    .collect(Collectors.toMap(
                            Employee::getName,
                            e -> e.getHireDate() + " (" + e.getHireDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + ")"
                    ));
        }

        // 14.14: Employees joined on a specific day
        public List<String> getEmployeesJoinedOnDay(String dayName) {
            return repository.getEmployees()
                    .stream()
                    .filter(e -> e.getHireDate().getDayOfWeek().name().equalsIgnoreCase(dayName))
                    .map(Employee::getName)
                    .collect(Collectors.toList());
        }

        // 14.15: Employee name and manager name
        public List<String> getEmployeeManagerReport() {
            return repository.getEmployees()
                    .stream()
                    .filter(e -> e.getManager() != null)
                    .map(e -> e.getName() + " reports to " + e.getManager().getName())
                    .collect(Collectors.toList());
        }

        // 14.16: Employee name, salary and increased salary
        public Map<String, String> getSalaryWithIncrement() {
            return repository.getEmployees()
                    .stream()
                    .collect(Collectors.toMap(
                            Employee::getName,
                            e -> "Original: " + e.getSalary() + ", Increased: " + (e.getSalary() * 1.15)
                    ));
        }

        // 14.17: Employees without manager
        public List<Employee> getEmployeesWithoutManager() {
            return repository.getEmployees()
                    .stream()
                    .filter(e -> e.getManager() == null)
                    .collect(Collectors.toList());
        }
    }

