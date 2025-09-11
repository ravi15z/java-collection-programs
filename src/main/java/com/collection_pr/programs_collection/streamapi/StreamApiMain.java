package com.collection_pr.programs_collection.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiMain {

    public static void main(String[] args) {

        List<Department> departments = addData();
        getAllEmployee(departments);

        System.out.println("=================================");
        getItEmplyee(departments);

        System.out.println("=================================");
        getHighsetId(departments);

        System.out.println("=================================");
        getCollect(departments);

        System.out.println("=================================");
        getReveresedEmployees(departments);

        System.out.println("=================================");
        getLength4(departments);

    }

    private static void getLength4(List<Department> departments) {
        List<String> length4 = departments.stream().flatMap(dep -> dep.getEmployees().stream())
                .filter(emp -> emp.getName().length() <= 4)
                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println(length4);
    }

    private static void getCollect(List<Department> departments) {
        System.out.println("Scenario 5: Group employees by department name");
        Map<String, List<Employee>> collect = departments.stream()
                .collect(Collectors.toMap(dep -> dep.getName(), dep -> dep.getEmployees()));
        System.out.println(collect);
    }

    private static void getItEmplyee(List<Department> departments) {
        System.out.println("Scenario 2: Employees only from IT department");
        List<String> itEmplyee = departments.stream().filter(dep -> dep.getName().equals("IT"))
                .flatMap(dep -> dep.getEmployees().stream())
                .map(Employee::getName)
                .collect(Collectors.toList());
        itEmplyee.forEach(System.out::println);
    }

    private static void getAllEmployee(List<Department> departments) {
        System.out.println("Scenario 1: Get all employees from all departments");
        List<Employee> allEmployee = departments.stream().flatMap(dep -> dep.getEmployees().stream())
                .collect(Collectors.toList());
        allEmployee.forEach(emp -> System.out.println(emp));
    }

    private static void getReveresedEmployees(List<Department> departments) {
        System.out.println("Scenario 5: sort employees reveresed by emp id");
        List<Employee> reveresedEmployees = departments.stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .sorted(Comparator.comparingInt(Employee::getId).reversed())
                .collect(Collectors.toList());
        System.out.println(reveresedEmployees);
    }

    private static void getHighsetId(List<Department> departments) {
        System.out.println("Scenario 3: Find highest employee ID across all departments");
        int highsetId = departments.stream().flatMap(dep -> dep.getEmployees().stream())
                .mapToInt(emp -> emp.getId())
                .max()
                .orElse(-1);
        System.out.println(highsetId);

        Employee max = departments.stream().flatMap(dep -> dep.getEmployees().stream())
                .max(Comparator.comparingInt(emp -> emp.getId())).get();
        System.out.println("Highest Id employee : " + max);

    }

    private static List<Department> addData() {
        Department it = new Department(1, "IT");
        Department hr = new Department(2, "HR");
        Employee e1 = new Employee(101, "Ravi");
        Employee e2 = new Employee(102, "Sneha");
        Employee e3 = new Employee(103, "Amit");
        it.getEmployees().add(e1);
        it.getEmployees().add(e2);
        hr.getEmployees().add(e3);
        List<Department> departments = Arrays.asList(it, hr);
        departments.forEach(System.out::println);
        return departments;
    }
}
