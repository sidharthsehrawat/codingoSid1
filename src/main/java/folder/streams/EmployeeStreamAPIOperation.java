package folder.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Employee {
    int id;
    String name;
    String gender;
    int age;
    String dept;
    double salary;
    int yearOfJoining;
}

public class EmployeeStreamAPIOperation {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        employeeList.add(new Employee(1, "Sid", "male", 2, "JAVA", 200, 2022));
        employeeList.add(new Employee(3, "Adam", "male", 3, "IT", 700, 2023));
        employeeList.add(new Employee(2, "Mike", "male", 4, "MECH", 200, 2024));
        employeeList.add(new Employee(4, "Don", "male", 1, "JAVA", 500, 2027));
        employeeList.add(new Employee(5, "Kel", "female", 21, "JAVA", 800, 2025));
        employeeList.add(new Employee(7, "Bat", "male", 6, "ECE", 900, 2023));
        employeeList.add(new Employee(6, "Sup", "female", 30, "MECH", 300, 2024));


        // how many male and female .
        // method1(employeeList);

        //print all dept in org.
        // method2(employeeList);

        // Avg age of male and female employees
        // method3(employeeList);

        // Highest paid employee in org. && Hihgest paid employee in male / female .
        // method4(employeeList);

        // emp joined after 2023
        // method5(employeeList);

        // count no of employees in each dept.
        // method6(employeeList);

        // avg salary of each dept.
        //method7(employeeList);

        // young emp in JAVA dept.
        // method8(employeeList);

        // most work experience in org.
        // method9(employeeList);

        // how many males and females in JAVA and MECH.
        //method10(employeeList);

        // Avg salary of male and female employee .
        //method11(employeeList);

        // All emp names in each dept.
        //  method12(employeeList);

        // Avg salary and whole salary in organization.
        // method13(employeeList);

        // Separate the employees whose age is below 6.
        // method14(employeeList);


        // oldest emp in org.
        //method15(employeeList);

        // max salary emp in each dept .
        //method16(employeeList);

        // emp count working in each dept
        method17(employeeList);

    }
    // emp count working in each dept
    private static void method17(List<Employee> employeeList) {
        Map<String, Long> emp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(emp);
    }
    // max salary emp in each dept .
    private static void method16(List<Employee> employeeList) {
        Map<String, Optional<Employee>> emp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(emp);
    }
    // oldest emp in org.
    private static void method15(List<Employee> employeeList) {
        Optional<Employee> emp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println(emp);

        // Only print
        Optional<Employee> emp1 = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst();
        System.out.println(emp1);
        //OR
        Optional<Employee> em = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(em);
    }
    // Separate the employees whose age is below 6.
    private static void method14(List<Employee> employeeList) {
        Map<Boolean, List<Employee>> part = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 6));
        System.out.println(part);
    }
    // Avg salary and whole salary in organization.
    private static void method13(List<Employee> employeeList) {
        // avg salary.
        Double res = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        // System.out.println(res);

        // whole salary
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        employeeList.stream().forEach(employee -> sum.set(sum.get() + employee.getSalary()));
        //  System.out.println(sum);

        // OR using summarizingmethod
        DoubleSummaryStatistics summary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(summary.getAverage());
        System.out.println(summary.getSum());
    }
    // All emp names in each dept.
    private static void method12(List<Employee> employeeList) {
        Map<String, List<Employee>> emp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(emp);
    }
    // Avg salary of male and female employee .
    private static void method11(List<Employee> employeeList) {
        Map<String, Double> emp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(emp);
    }
    // how many males and females in JAVA and MECH.
    private static void method10(List<Employee> employeeList) {
        Map<String, Long> emp = employeeList.stream().filter(employee -> employee.getDept().equals("JAVA") || employee.getDept().equals("MECH")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(emp);
    }

    // most work experience in org.
    private static void method9(List<Employee> employeeList) {
        Optional<Employee> res = employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        System.out.println(res);
        // OR
        Optional<Employee> emp = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        System.out.println(emp);
    }

    // young emp in JAVA dept.
    private static void method8(List<Employee> employeeList) {
        Optional<Employee> res = employeeList.stream().filter(employee -> employee.getDept().equals("JAVA")).collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println(res);
    }

    // avg salary of each dept.
    private static void method7(List<Employee> employeeList) {
        Map<String, Double> res = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(res);
    }

    // count no of employees in each dept.
    private static void method6(List<Employee> employeeList) {
        Map<String, Long> res = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(res);
    }
    // emp joined after 2023
    private static void method5(List<Employee> employeeList) {
        List<Employee> ans = employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2023).sorted(Comparator.comparingInt(Employee::getYearOfJoining)).collect(Collectors.toList());
        System.out.println("employees joined after 2023 : " + ans);
        // print names only emp joined after 2023.
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2023).map(Employee::getName).forEach(System.out::println);
    }

    // Highest paid employee in org. && Hihgest paid employee in male / female .
    private static void method4(List<Employee> employeeList) {
        Employee emp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
        System.out.println("Employee : " + emp);

        // OR

        Optional<Employee> ans = employeeList.stream().filter(employee -> employee.getGender().equals("female")).collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("max Salary Employee : " + ans.get());
    }

    // Avg age of male and female employees
    private static void method3(List<Employee> employeeList) {
        Map<String, Double> res3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        Double ans = employeeList.stream().filter(employee -> employee.getGender().equals("male")).collect(Collectors.averagingInt(Employee::getAge));
        System.out.println("Avg Age of Male Only " + ans);
        System.out.println("Avg Age of Male and female combined " + res3);
    }

    //print all dept in org.
    private static void method2(List<Employee> employeeList) {
        employeeList.stream().map(Employee::getDept).distinct().forEach(System.out::println);
    }

    // how many male and female .
    private static void method1(List<Employee> employeeList) {
        Map<String, Long> res = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Males and Females :  " + res);
    }


}


