import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIList {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Ravi", 24, 50000.00));
        employeeList.add(new Employee("Sai", 26, 30000.00));
        employeeList.add(new Employee("Koti", 27, 60000.00));
        employeeList.add(new Employee("Gouri", 30, 90000.00));
        employeeList.add(new Employee("Kiran", 24, 35000.00));

        //Employee with second-highest age
        Employee secondHighestAgeEmployee = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .toList()
                .get(1);
        System.out.println(secondHighestAgeEmployee);

        //Groups employee objects based on 'Age' property
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge))
                .values()
                .forEach(System.out::println);

        //Remove(Filter out) employees who age is greater than 25
        List<Employee> employees = employeeList.stream()
                .filter(e -> e.getAge() <= 25)
                .toList();
        for(Employee e: employees){
            System.out.println(e);
        }
    }
}

class Employee{
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}