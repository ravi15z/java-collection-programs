package com.collection_pr.programs_collection.regular_programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class General {

    public static void main(String[] args) {

        // notice 30 and 40 are repeating but are NOT duplicates (not filtered before)
        List<Integer> intList = Arrays.asList(10, 20, 30, 30, 40, 40, 50, 10, 20);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        // find duplicates (10 and 20 appear more than once)
        intList.forEach(n -> {
            if (!seen.add(n)) {
                duplicates.add(n);
            }
        });

        // filter out duplicates but WITHOUT distinct()
        List<Integer> unique = intList.stream()
                .filter(n -> !duplicates.contains(n)) // removes 10,20 only
                .collect(Collectors.toList());

        System.out.println("Without distinct: " + unique);

        palindromNum();

    }

    private static void palindromNum() {
        System.out.println("Palindrom program: ");
        int num = 151;
        int rev = 0;
        int temp = 0;
        while (0 < num) {
            temp = num % 10;
            rev = (rev * 10) + temp;
            num = num / 10;
            System.out.println("temp =" + temp + " rev= " + rev + " num=" + num);
        }
    }
}
