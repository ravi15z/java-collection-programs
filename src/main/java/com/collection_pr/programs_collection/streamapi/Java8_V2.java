package com.collection_pr.programs_collection.streamapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8_V2 {
        public static void main(String[] args) {
                IntStreamUses();
                System.out.println("Print duplicate characters in a string?");
                getData1();
                System.out.println("=================================");

                System.out.println("=================================");

        }

        private static void IntStreamUses() {
                System.out.print("IntStream.range(1, 5): ");
                IntStream.range(1, 5).forEach(s -> System.out.print(s));
                System.out.println("\nIntStream.rangeClosed(1, 5): ");
                IntStream.rangeClosed(1, 5).forEach(s -> System.out.print(s));
                System.out.print("\nIntStream.of(1, 2, 3): ");
                IntStream.of(1, 2, 3).forEach(s -> System.out.print(s));
        }

        private static void getData1() {
                String inputString = "Java Concept Of The Day";
                System.out.println(inputString);
                Set<String> collect1 = Arrays.stream(inputString.split(""))
                                .filter(c -> !c.equals(" "))
                                .collect(Collectors.toSet());
                System.out.println("Using HashSet:: " + collect1);
                Set<String> collect2 = Arrays.stream(inputString.split(""))
                                .filter(c -> !c.equals(" "))
                                .collect(Collectors.toCollection(LinkedHashSet::new));
                System.out.println("Using Linked HashSet:: " + collect2);

                // Collectors.toMap expects keyMapper and valueMapper,
                // but you’re giving it a downstream collector (Collectors.counting())
                // which is only valid inside groupingBy.
                /*
                 * Arrays.stream(inputString.split("")).filter(c -> !c.equals(" "))
                 * .collect(Collectors.toMap(Function.identity(),Collectors.counting()));
                 */
                Arrays.stream(inputString.split("")).filter(c -> !c.equals(" "))
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .forEach((key, value) -> System.out.println(key + value));
                Arrays.stream(inputString.split("")).filter(c -> !c.equals(" "))
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        }
}
