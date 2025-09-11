package com.collection_pr.programs_collection.mapPr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        // Creating a list of employees

        List<Employee> employeeList = new ArrayList<Employee>();

        // Adding employees to employeeList

        employeeList.add(new Employee("Paul Strong", 41));
        employeeList.add(new Employee("Vijay Reddy", 27));
        employeeList.add(new Employee("Ali Baig", 23));
        employeeList.add(new Employee("Sid Ram", 34));
        employeeList.add(new Employee("Nicolus Den", 38));
        employeeList.add(new Employee("Prateeksha Yalkote", 25));
        employeeList.add(new Employee("Sanvi Roy", 30));
        employeeList.add(new Employee("Neha Pandey", 28));
        employeeList.add(new Employee("Arnav Joshi", 49));
        employeeList.add(new Employee("Darren Li", 36));

        partitionFunctins(employeeList);

    }

    private static void partitionFunctins(List<Employee> employeeList) {
        // Partitioning employees by age
        Map<Boolean, List<Employee>> aMap = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        System.out.println("==============================================");
        System.out.println("Employee Partition By Age > 30 from Age <= 30");
        System.out.println("==============================================");
        for (Map.Entry<Boolean, List<Employee>> en : aMap.entrySet()) {
            if (en.getKey()) {
                System.out.println("age is > 30: " + en.getValue());
            } else {
                System.out.println("age is < 30: " + en.getValue());
            }
        }
    }
}
