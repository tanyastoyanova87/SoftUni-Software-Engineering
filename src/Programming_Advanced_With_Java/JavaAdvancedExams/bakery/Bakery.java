package Programming_Advanced_With_Java.JavaAdvancedExams.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
               return this.employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee employee = null;
        int oldest = Integer.MIN_VALUE;
        for (Employee employee1 : this.employees) {
            if (employee1.getAge() > oldest) {
                oldest = employee1.getAge();
                employee = employee1;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n", this.name));
        for (Employee employee : this.employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
